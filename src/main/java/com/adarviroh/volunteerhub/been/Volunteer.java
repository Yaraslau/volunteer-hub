package com.adarviroh.volunteerhub.been;

/**
 * Created by Yaraslau_Dubovik on 03/02/2024
 */
public class Volunteer {

    private long id;
    private User user;
    private Activity activity;

    public Volunteer(long id, User user, Activity activity) {
        this.id = id;
        this.user = user;
        this.activity = activity;
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
