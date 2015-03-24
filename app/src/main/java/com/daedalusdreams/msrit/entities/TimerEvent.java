package com.daedalusdreams.msrit.entities;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Represents a specific TimerEvent, one or more of which make up a Timer. (TimerEvents are what contain the actual countdown length information.)
 *
 * Each timer event has a target number of seconds, and a random variability range.
 * For example, an event may be 60 seconds long, with 10 seconds of variability, which means it will
 * run for somewhere between 50 and 70 seconds.)
 *
 * Created by joshproehl on 3/23/15.
 */
public class TimerEvent implements Parcelable {
    // How long is this specific event going to last.
    private int seconds;
    // The number of seconds that we could be before or after the target seconds.
    private int secondsFlux;

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

    public int getSecondsFlux() {
        return secondsFlux;
    }

    public void setSecondsFlux(int secondsFlux) {
        this.secondsFlux = secondsFlux;
    }

    //endregion
    //region Implementing Parcelable

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(seconds);
        out.writeInt(secondsFlux);
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
        secondsFlux = in.readInt();
    }

    //endregion
}
