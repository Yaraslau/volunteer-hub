package com.adarviroh.volunteerhub.been;

import com.adarviroh.volunteerhub.been.type.ActivityType;

import jakarta.persistence.*;
import java.util.List;


/**
 * Created by Yaraslau_Dubovik on 03/01/2024
 */
@Entity
@Table(schema = "APP", name = "ACTIVITY")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Enumerated(EnumType.ORDINAL)
    private ActivityType type;
    private int demand;
    private int capacity;
    private int salary;

    @OneToMany
    @JoinColumn(name = "ACTIVITY_ID")
    private List<Volunteer> volunteers;

    public Activity() {
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

    public List<Volunteer> getVolunteers() {
        return volunteers;
    }

    public void setVolunteers(List<Volunteer> volunteers) {
        this.volunteers = volunteers;
    }

    @Override
    public String toString() {
        return "Activity: " + this.name + "; Demand: " + this.demand
                + "; Available: " + (this.demand >= this.capacity ? this.demand - this.capacity : 0)
                + "; Salary: " + this.salary;
    }
}
