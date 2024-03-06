package com.adarviroh.volunteerhub.been;

import com.adarviroh.volunteerhub.been.type.UserType;

/**
 * Created by Yaraslau_Dubovik on 03/01/2024
 */
public class User extends Entity {
    private long id;
    private UserType type;
    private String name;
    private String password;

    public User() {
    }

    public User(long id, String name, String password, UserType type) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.type = type;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "id = " + this.id + " - " + this.name;
    }
}
