package com.daedalusdreams.msrit.entities;

import java.io.Serializable;

/**
 * Represents a specific TimerEvent, one or more of which make up a Timer. (TimerEvents are what contain the actual countdown length information.)
 *
 * Created by joshproehl on 3/23/15.
 */
public class TimerEvent implements Serializable {
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
}
