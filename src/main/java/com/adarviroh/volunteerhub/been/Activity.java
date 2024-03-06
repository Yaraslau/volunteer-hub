package com.adarviroh.volunteerhub.been;

import com.adarviroh.volunteerhub.been.type.ActivityType;

/**
 * Created by Yaraslau_Dubovik on 03/01/2024
 */
public class Activity {

    private long id;
    private String name;
    private Event event;
    private ActivityType type;
    private int demand;
    private int capacity;
    private int salary;

    public Activity(long id, String name, Event event, ActivityType type, int demand, int capacity, int salary) {
        this.id = id;
        this.name = name;
        this.event = event;
        this.type = type;
        this.demand = demand;
        this.capacity = capacity;
        this.salary = salary;
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

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public ActivityType getType() {
        return type;
    }

    public void setType(ActivityType type) {
        this.type = type;
    }

    public int getDemand() {
        return demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Activity: " + this.name + "; Demand: " + this.demand
                + "; Available: " + (this.demand >= this.capacity ? this.demand - this.capacity : 0)
                + "; Salary: " + this.salary;
    }
}
