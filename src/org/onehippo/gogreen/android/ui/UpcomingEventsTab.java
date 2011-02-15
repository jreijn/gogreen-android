package org.onehippo.gogreen.android.ui;

import java.util.ArrayList;

import org.onehippo.gogreen.android.R;
import org.onehippo.gogreen.android.adapter.EventAdapter;
import org.onehippo.gogreen.android.data.Event;

import android.app.ListActivity;
import android.os.Bundle;

/**
 * Tab container for showing upcoming events.
 * 
 * @author Jeroen Reijn
 */
public class UpcomingEventsTab extends ListActivity {

    private ArrayList<Event> events;
    private EventAdapter eventAdapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_content);

        events = new ArrayList<Event>();
        eventAdapter = new EventAdapter(this, R.layout.list_item_event, events);
        setListAdapter(eventAdapter);
    }
}
