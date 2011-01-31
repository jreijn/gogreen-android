package org.onehippo.gogreen.android.ui;

import java.util.ArrayList;
import java.util.Calendar;

import org.onehippo.gogreen.android.Event;
import org.onehippo.gogreen.android.R;
import org.onehippo.gogreen.android.adapter.EventAdapter;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

/**
 * @author Jeroen Reijn
 */
public class PastEventsTab extends ListActivity {

    private ProgressDialog m_ProgressDialog = null;
    private ArrayList<Event> m_events = null;
    private EventAdapter m_adapter;
    private Runnable viewEvents;

    private ListView eventsListView;
    //private CursorAdapter mAdapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_content);
        eventsListView = getListView();

        m_events = new ArrayList<Event>();
        m_adapter = new EventAdapter(this, R.layout.list_item_event, m_events);
        setListAdapter(m_adapter);

        viewEvents = new Runnable() {

            public void run() {
                getEvents();
            }
        };

        Thread thread = new Thread(null, viewEvents, "MagentoBackground");
        thread.start();
        m_ProgressDialog = ProgressDialog.show(PastEventsTab.this,
                "Please wait...", "Retrieving data ...", true);

/*
        mAdapter = new EventsAdapter(this);
        setListAdapter(mAdapter);
*/

    }

    private void getEvents() {
        try {
            Calendar cal = Calendar.getInstance();
            m_events = new ArrayList<Event>();
            Event e1 = new Event();
            e1.setDate(cal.getTime());
            e1.setTitle("Guelph Organic Conference");
            Event e2 = new Event();
            cal.add(Calendar.MONTH, -2);
            e2.setDate(cal.getTime());
            e2.setTitle("Ecobuild 2011");
            m_events.add(e1);
            m_events.add(e2);
            Log.i("ARRAY", "" + m_events.size());
        } catch (Exception e) {
            Log.e("BACKGROUND_PROC", e.getMessage());
        }
        runOnUiThread(returnRes);
    }

    private Runnable returnRes = new Runnable() {

        public void run() {
            if (m_events != null && m_events.size() > 0) {
                m_adapter.notifyDataSetChanged();
                for (int i = 0; i < m_events.size(); i++) {
                    m_adapter.add(m_events.get(i));
                }
            }
            m_ProgressDialog.dismiss();
            m_adapter.notifyDataSetChanged();
        }
    };

    /*private class EventsAdapter extends CursorAdapter {
        public EventsAdapter(final Context context) {
            super(context,null);
        }

        @Override
        public View newView(final Context context, final Cursor cursor, final ViewGroup viewGroup) {
            return getLayoutInflater().inflate(R.layout.list_item_event, viewGroup, false);
        }

        @Override
        public void bindView(final View view, final Context context, final Cursor cursor) {
            final TextView titleView = (TextView) view.findViewById(R.id.event_title);
            titleView.setText("test");
        }
    }*/


}
