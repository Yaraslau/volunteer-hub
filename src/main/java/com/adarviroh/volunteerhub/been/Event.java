package com.adarviroh.volunteerhub.been;

import com.adarviroh.volunteerhub.been.type.EventType;
import jakarta.persistence.*;
import java.util.List;

/**
 * Created by Yaraslau_Dubovik on 03/02/2024
 */
@Entity
@Table(schema = "APP", name = "EVENT")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Enumerated(EnumType.ORDINAL)
    private EventType type;

    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private User owner;

    @OneToMany
    @JoinColumn(name = "EVENT_ID")
    private List<Activity> activities;

    public Event() {
    }

    public long getId() {
        return id;
    }

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

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "Event: " + this.name + "; Owner: " + this.owner.getName();
    }
}
