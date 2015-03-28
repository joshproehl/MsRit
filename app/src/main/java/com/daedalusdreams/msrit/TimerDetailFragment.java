package com.daedalusdreams.msrit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.daedalusdreams.msrit.entities.Timer;

import java.util.ArrayList;

/**
 * A fragment representing a single Timer detail screen.
 * This fragment is either contained in a {@link TimerListActivity}
 * in two-pane mode (on tablets) or a {@link TimerDetailActivity}
 * on handsets.
 */
public class TimerDetailFragment extends Fragment {
    // The position in the list for the item we're interested in
    public static final String ITEM_POS_KEY = "MsRit.selectedItem.intPos";


    private ArrayList<Timer> _timersList;   // The list of timers from the app context
    private int _selectedTimer;             // The position in the list of the one this fragment is working with. (From the intent)
    private Timer _timer;                   // The specific timer out of the list that we're working with.


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public TimerDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the list of timers from the application so we can view/edit
        _timersList = ((MsRitApplication)getActivity().getApplicationContext()).getTimers();

        if (getArguments().containsKey(ITEM_POS_KEY)) {
            _selectedTimer = savedInstanceState.getInt(ITEM_POS_KEY);
            _timer = _timersList.get(_selectedTimer);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_timer_detail, container, false);

        if (_timer != null) {
            ((TextView) rootView.findViewById(R.id.detail_timer_name)).setText(_timer.getName());
        }

        return rootView;
    }
}
