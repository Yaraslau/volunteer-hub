package com.adarviroh.volunteerhub.been;

import com.adarviroh.volunteerhub.been.type.EventType;

/**
 * Created by Yaraslau_Dubovik on 03/02/2024
 */
public class Event extends Entity {

    private long id;
    private String name;
    private EventType type;
    private User owner;

    public Event() {
    }

    public Event(long id, String name, EventType type, User owner) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.owner = owner;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Event: " + this.name + "; Owner: " + this.owner.getName();
    }
}
