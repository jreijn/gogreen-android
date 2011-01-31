package org.onehippo.gogreen.android.adapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.onehippo.gogreen.android.Event;
import org.onehippo.gogreen.android.R;
import org.onehippo.gogreen.android.ui.view.SimpleCalendarView;

import android.view.LayoutInflater;
import android.view.View;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class EventAdapter extends ArrayAdapter<Event> {

        private ArrayList<Event> items;
        private Context context;

        public EventAdapter(Context context, int textViewResourceId, ArrayList<Event> items) {
            super(context, textViewResourceId, items);
            this.items = items;
            this.context = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.list_item_event, null);
            }
            Event event = items.get(position);
            if (event != null) {
                TextView tt = (TextView) v.findViewById(R.id.event_title);
                if (tt != null) {
                    tt.setText(event.getTitle());
                }
                SimpleCalendarView dateView = (SimpleCalendarView) v.findViewById(R.id.calendar_today);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(event.getDate());
                dateView.setDate(calendar.get(Calendar.DAY_OF_MONTH));
                SimpleDateFormat dateFormat = new SimpleDateFormat("MMM");
                String month = dateFormat.format(calendar.getTime());
                dateView.setMonth(month);
            }
            return v;
        }
    }