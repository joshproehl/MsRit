package com.daedalusdreams.msrit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.daedalusdreams.msrit.entities.Timer;

import java.util.ArrayList;


/**
 * An activity representing a list of Timers. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link TimerDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p/>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link TimerListFragment} and the item details
 * (if present) is a {@link TimerDetailFragment}.
 * <p/>
 * This activity also implements the required
 * {@link TimerListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class TimerListActivity extends FragmentActivity
        implements TimerListFragment.Callbacks {

     // Whether or not the activity is in two-pane mode, i.e. running on a tablet device.
    private boolean mTwoPane;

    // The list of timers that we'll be displaying.
    private ArrayList<Timer> _timersList;

    private final String TIMERS_LIST = "timers_list_bundle_key";

    //region Instance management

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_list);

        // Try and get any saved timers out of the saved instance state, otherwise create an empty list
        if(savedInstanceState != null && !savedInstanceState.isEmpty()) {
            _timersList = savedInstanceState.getParcelableArrayList(TIMERS_LIST);
        } else {
            _timersList = new ArrayList<>();
        }

        if (findViewById(R.id.timer_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((TimerListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.timer_list))
                    .setActivateOnItemClick(true);
        }

        // TODO: If exposing deep links into your app, handle intents here.
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Serialize and Save the list into shared preferences
        outState.putParcelableArrayList(TIMERS_LIST, _timersList);
    }

    //endregion
    //region Required implementations

    /**
     * Callback method from {@link TimerListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(int position) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putInt(TimerDetailFragment.ITEM_POS_KEY, position);
            TimerDetailFragment fragment = new TimerDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.timer_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, TimerDetailActivity.class);
            detailIntent.putExtra(TimerDetailFragment.ITEM_POS_KEY, position);
            startActivity(detailIntent);
        }
    }

    //endregion
}
