package com.daedalusdreams.msrit.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Represents a parent Timer, which is a list of individual timer events.
 *
 * Created by joshproehl on 3/23/15.
 */
public class Timer implements Parcelable {
    private ArrayList<TimerEvent> events;
    private String name;


    //region Custom accessor methods

    public boolean addEvent(TimerEvent t) {
        return events.add(t);
    }

    public boolean addEvent(int seconds) {
        return events.add(new TimerEvent(seconds));
    }

    //endregion
    //region Generated Getters/Setters

    public ArrayList<TimerEvent> getEvents() {
        return events;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //endregion
    //region Implementing Parcelable

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(name);
        out.writeTypedList(events);
    }

    public static final Parcelable.Creator<Timer> CREATOR
            = new Parcelable.Creator<Timer>() {
        public Timer createFromParcel(Parcel in) {
            return new Timer(in);
        }

        public Timer[] newArray(int size) {
            return new Timer[size];
        }
    };

    private Timer(Parcel in) {
        name = in.readString();
        events = in.createTypedArrayList(TimerEvent.CREATOR);
    }

    //endregion
}
