package org.onehippo.gogreen.android.ui;

import org.onehippo.gogreen.android.R;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Tab container for showing upcoming events.
 * 
 * @author Jeroen Reijn
 */
public class UpcomingEventsTab extends ListActivity {

    private String lv_arr[] = {"Nokia", "Siemens", "Motorola"};

    private ListView eventsListView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_content);
        eventsListView = getListView();
        eventsListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lv_arr));
    }
}
