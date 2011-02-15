package org.onehippo.gogreen.android.adapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.onehippo.gogreen.android.R;
import org.onehippo.gogreen.android.data.Event;
import org.onehippo.gogreen.android.ui.view.SimpleCalendarView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Adapter for showing events in a list view.
 *
 * @author Jeroen Reijn
 */
public class EventAdapter extends ArrayAdapter<Event> {

    private static final String MONTH_DATE_FORMAT = "MMM";
    private ArrayList<Event> items;
    private Context context;

    public EventAdapter(Context context, int textViewResourceId, ArrayList<Event> items) {
        super(context, textViewResourceId, items);
        this.items = items;
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View itemView = view;
        if (itemView == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = vi.inflate(R.layout.list_item_event, null);
        }
        Event event = items.get(position);
        if (event != null) {
            addTitleToView(itemView, event);
            addCalendarToItemView(itemView, event);
        }
        return itemView;
    }

    private void addCalendarToItemView(final View itemView, final Event event) {
        SimpleCalendarView dateView = (SimpleCalendarView) itemView.findViewById(R.id.calendar_today);
        SimpleDateFormat dateFormat = new SimpleDateFormat(MONTH_DATE_FORMAT);

        dateView.setDate(event.getStartDate().get(Calendar.DAY_OF_MONTH));
        String month = dateFormat.format(event.getStartDate().getTime());
        dateView.setMonth(month);
    }

    private void addTitleToView(final View itemView, final Event event) {
        TextView tt = (TextView) itemView.findViewById(R.id.event_title);
        if (tt != null) {
            tt.setText(event.getTitle());
        }
    }
}