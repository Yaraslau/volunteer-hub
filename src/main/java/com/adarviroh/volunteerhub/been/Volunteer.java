package com.adarviroh.volunteerhub.been;

import jakarta.persistence.*;

/**
 * Created by Yaraslau_Dubovik on 03/02/2024
 */
@Entity
@Table(schema = "APP", name = "VOLUNTEER")
public class Volunteer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public Volunteer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Volunteer: " + this.user.getName();
    }
}
