package org.onehippo.gogreen.android.ui;

import org.onehippo.gogreen.android.R;
import org.onehippo.gogreen.android.utils.UIUtils;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * Activity for the events screen
 * 
 * @author Jeroen Reijn
 */
public class EventsActivity extends TabActivity {

    public static final String TAG_UPCOMING = "upcoming";
    public static final String TAG_PAST = "past";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        TabHost host = getTabHost();
        TabHost.TabSpec spec;
        Intent intent;

        setupUpcomingTab(host);
        setupPastTab(host);
    }

    private void setupUpcomingTab(TabHost host) {
        Intent intent = new Intent(this, UpcomingEventsTab.class);
        TabHost.TabSpec upcomingTab = host.newTabSpec(TAG_UPCOMING)
                .setIndicator(buildIndicator(R.string.title_upcoming_events_tab))
                .setContent(intent);
        host.addTab(upcomingTab);
    }

    private void setupPastTab(TabHost host) {
        Intent intent = new Intent(this, PastEventsTab.class);
        TabHost.TabSpec pastTab = host.newTabSpec(TAG_PAST)
                .setIndicator(buildIndicator(R.string.title_past_events_tab))
                .setContent(intent);
        host.addTab(pastTab);
    }

    /**
     * Build a {@link View} to be used as a tab indicator, setting the requested
     * string resource as its label.
     */
    private View buildIndicator(int textRes) {
        final TextView indicator = (TextView) getLayoutInflater().inflate(R.layout.tab_indicator,
                getTabWidget(), false);
        indicator.setText(textRes);
        return indicator;
    }

    /**
     * Handle "search" title-bar action.
     * @param v the view
     */
    public void onEventsSearchClick(View v) {
        UIUtils.goSearch(this);
    }


    public void onHomeClick(View v) {
        UIUtils.goHome(this);
    }
}
