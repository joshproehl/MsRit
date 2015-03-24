package com.daedalusdreams.msrit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.daedalusdreams.msrit.entities.Timer;

import java.util.ArrayList;

/**
 * A ListAdapter for displaying timer_list_element layouts.
 *
 * Created by joshproehl on 3/24/15.
 */
public class TimerListAdapter extends ArrayAdapter<Timer> {
    private final Context context;
    private final ArrayList<Timer> timers;

    public TimerListAdapter(Context context, ArrayList<Timer> timers) {
        super(context, 0, timers);
        this.context = context;
        this.timers = timers;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if(v == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.timer_list_element_layout, parent, false);
        }

        Timer tt = timers.get(position);

        if(tt != null) {
            TextView tvTimerName = (TextView) v.findViewById(R.id.list_timer_name);
            TextView tvEventCount = (TextView) v.findViewById(R.id.list_event_count);

            tvTimerName.setText(tt.getName());
            tvEventCount.setText(tt.getEvents().size() + " events");
        }

        return v;
    }
}
