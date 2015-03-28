package com.daedalusdreams.msrit;

import android.app.Application;
import android.content.SharedPreferences;

import com.daedalusdreams.msrit.entities.Timer;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by joshproehl on 3/28/15.
 */
public class MsRitApplication extends Application {
    public final String TAG = "MsRitApplication";
    public final String SHARED_PREFS_KEY = "com.daedalusdreams.msrit.prefs";
    public final String DATA_PREFS_KEY = "timers_list_json";

    private ArrayList<Timer> _timers;


    /**
     * Get the (memoized) list of timers that we're saving.
     *
     * We save the list to a local variable, and only return that in the case that it exists...
     * It is assumed that nobody will ever update the timers list except by means of this class
     * and it's setTimers() method, otherwise things may become out of sync and data could be lost.
     *
     * @return The currently saved list of timers
     */
    public ArrayList<Timer> getTimers() {
        if(_timers == null) {
            String jsonList = getSharedPreferences(SHARED_PREFS_KEY, 0).getString(DATA_PREFS_KEY, "");
            if(jsonList.length() > 0) {
                // We actually have saved JSON, let's deserialize it
                Gson parser = new Gson();
                Type arrayListType = new TypeToken<ArrayList<Timer>>(){}.getType();

                _timers = parser.fromJson(jsonList, arrayListType);
            } else {
                // No saved JSON found, so we'll initialize our timers as an empty list
                _timers = new ArrayList<>();
            }
        }

        return _timers;
    }

    /**
     * Overwrite the list of timers with a new one.
     *
     * @param newTimers The new list of timers which will be saved.
     */
    public void setTimers(ArrayList<Timer> newTimers) {
        _timers = newTimers;

        Gson parser = new Gson();
        String listAsJson = parser.toJson(newTimers);

        SharedPreferences.Editor editor = getSharedPreferences(SHARED_PREFS_KEY, 0).edit();
        editor.putString(DATA_PREFS_KEY, listAsJson);
        editor.commit();
    }
}
