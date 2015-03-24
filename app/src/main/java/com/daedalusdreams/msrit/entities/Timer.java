package com.daedalusdreams.msrit.entities;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a parent Timer, which is a list of individual timer events.
 *
 * Created by joshproehl on 3/23/15.
 */
public class Timer implements Serializable {
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
}
