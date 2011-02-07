package org.onehippo.gogreen.android.ui;

import java.util.ArrayList;

import org.onehippo.gogreen.android.Event;
import org.onehippo.gogreen.android.R;
import org.onehippo.gogreen.android.adapter.EventAdapter;
import org.onehippo.gogreen.android.data.EventsRetriever;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

/**
 * Tab for showing past events
 *
 * @author Jeroen Reijn
 */
public class PastEventsTab extends ListActivity {

    private ProgressDialog progressDialog = null;
    private ArrayList<Event> events;
    private EventAdapter eventAdapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_content);

        events = new ArrayList<Event>();
        eventAdapter = new EventAdapter(this, R.layout.list_item_event, events);
        setListAdapter(eventAdapter);

        final Runnable viewEvents = new Runnable() {

            public void run() {
                getEvents();
            }
        };

        Thread thread = new Thread(null, viewEvents, "MagentoBackground");
        thread.start();
        progressDialog = ProgressDialog.show(PastEventsTab.this,
                "Please wait...", "Retrieving data ...", true);

    }


    @Override
    protected void onListItemClick(final ListView l, final View v, final int position, final long id) {
        startActivity(new Intent(this,EventDetailActivity.class));
    }

    private void getEvents() {
        try {
            events = EventsRetriever.getPastEvents();
            Log.i("ARRAY", "" + events.size());
        } catch (Exception e) {
            Log.e("BACKGROUND_PROC", e.getMessage());
        }
        runOnUiThread(returnRes);
    }

    private Runnable returnRes = new Runnable() {

        public void run() {
            if (events != null && events.size() > 0) {
                eventAdapter.notifyDataSetChanged();
                for (Event event : events) {
                    eventAdapter.add(event);
                }
            }
            progressDialog.dismiss();
            eventAdapter.notifyDataSetChanged();
        }
    };

}
