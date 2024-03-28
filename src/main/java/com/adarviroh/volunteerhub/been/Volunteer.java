package com.adarviroh.volunteerhub.been;

import javax.persistence.*;

/**
 * Created by Yaraslau_Dubovik on 03/02/2024
 */
@Entity
@Table(schema = "APP", name = "VOLUNTEER")
public class Volunteer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToOne
    @JoinColumn(name = "ACTIVITY_ID")
    private Activity activity;

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

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "Activity: " + this.activity.getName() + "; Volunteer: " + this.user.getName();
    }
}
