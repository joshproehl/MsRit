package com.daedalusdreams.msrit.entities;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Represents a specific TimerEvent, one or more of which make up a Timer. (TimerEvents are what contain the actual countdown length information.)
 *
 * Created by joshproehl on 3/23/15.
 */
public class TimerEvent implements Parcelable {
    private int seconds;

    public TimerEvent(int seconds) {
        this.seconds = seconds;
    }

    //region Generated Getters/Setters

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    //endregion
    //region Implementing Parcelable

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(seconds);
    }

    public static final Parcelable.Creator<TimerEvent> CREATOR
            = new Parcelable.Creator<TimerEvent>() {
        public TimerEvent createFromParcel(Parcel in) {
            return new TimerEvent(in);
        }

        public TimerEvent[] newArray(int size) {
            return new TimerEvent[size];
        }
    };

    private TimerEvent(Parcel in) {
        seconds = in.readInt();
    }

    //endregion
}
