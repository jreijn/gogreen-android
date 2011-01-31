package org.onehippo.gogreen.android.ui.view;

import org.onehippo.gogreen.android.R;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Simple calendar view for events
 *
 * @author Jeroen Reijn
 */
public class SimpleCalendarView extends FrameLayout {

    private ImageView calendarImageView = null;
    private TextView calendarMonthTextView = null;
    private TextView calendarDayTextView = null;

    public SimpleCalendarView(Context context) {
        super(context);
    }

    public SimpleCalendarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        setUpImageView(context);
        setUpDayView(context);
        setUpMonthView(context);

        /* Add child views to this object. */
        this.addView(this.calendarImageView);
        this.addView(this.calendarMonthTextView);
        this.addView(this.calendarDayTextView);
    }

    /**
     * Setup the month {@link TextView}
     * @param context the {@link Context}
     */
    private void setUpMonthView(final Context context) {
        this.calendarMonthTextView = new TextView(context);
        this.calendarMonthTextView.setText("");
        this.calendarMonthTextView.setTextSize(7);
        this.calendarMonthTextView.setTypeface(Typeface.create("Tahoma", Typeface.BOLD));
        this.calendarMonthTextView.setPadding(0, 4, 0, 0);
        this.calendarMonthTextView.setTextColor(Color.WHITE);
        this.calendarMonthTextView.setGravity(Gravity.CENTER_HORIZONTAL);
    }

    /**
     * Setup the day {@link TextView}
     * @param context the {@link Context}
     */
    private void setUpDayView(final Context context) {
        this.calendarDayTextView = new TextView(context);
        this.calendarDayTextView.setText("");
        this.calendarDayTextView.setTextSize(12);
        this.calendarDayTextView.setTypeface(Typeface.create("Tahoma", Typeface.BOLD));
        this.calendarDayTextView.setPadding(0, 13, 0, 0);
        this.calendarDayTextView.setTextColor(Color.WHITE);
        this.calendarDayTextView.setGravity(Gravity.CENTER_HORIZONTAL);
    }

    /**
     * Sets up the empty calendar view
     * @param context the {@link Context}
     */
    private void setUpImageView(final Context context) {
        calendarImageView = new ImageView(context);
        calendarImageView.setImageResource(R.drawable.bg_calendar);
        calendarImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    /**
     * Sets the day of the calendar view
     * @param day the day to show on the calendar
     */
    public void setDate(final int day) {
        this.calendarDayTextView.setText(Integer.toString(day));
    }

    /**
     * Sets the month on the calendar view
     * @param month the month to show on the calendar
     */
    public void setMonth(final String month) {
        this.calendarMonthTextView.setText(month);
    }
}
