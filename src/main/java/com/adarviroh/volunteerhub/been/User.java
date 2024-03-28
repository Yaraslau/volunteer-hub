package com.adarviroh.volunteerhub.been;

import com.adarviroh.volunteerhub.been.type.UserType;

import javax.persistence.*;

/**
 * Created by Yaraslau_Dubovik on 03/01/2024
 */
@Entity
@Table(schema = "APP", name = "APP_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.ORDINAL)
    private UserType type;

    private String name;
    private String password;

    public User() {
    }

    public void setId(long id) {
        this.id = id;
    }

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
