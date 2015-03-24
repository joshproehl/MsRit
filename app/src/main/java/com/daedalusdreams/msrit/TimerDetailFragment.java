package com.daedalusdreams.msrit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.daedalusdreams.msrit.dummy.DummyContent;

/**
 * A fragment representing a single Timer detail screen.
 * This fragment is either contained in a {@link TimerListActivity}
 * in two-pane mode (on tablets) or a {@link TimerDetailActivity}
 * on handsets.
 */
public class TimerDetailFragment extends Fragment {
    public static final String ARG_ITEM_ID = "item_id";
     // The fragment argument representing the item ID that this fragment represents.

    private DummyContent.DummyItem mItem;
     // The content this fragment is presenting.

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public TimerDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_timer_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.timer_detail)).setText(mItem.content);
        }

        return rootView;
    }
}
