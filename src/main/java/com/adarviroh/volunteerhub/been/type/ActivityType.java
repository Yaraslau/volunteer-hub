package com.adarviroh.volunteerhub.been.type;

/**
 * Created by Yaraslau_Dubovik on 03/01/2024
 */
public enum ActivityType {

    FREE, PAID_ACTIVITY;

    public static ActivityType getType(int code) {
        ActivityType type = ActivityType.FREE;
        for(ActivityType at : ActivityType.values()) {
            if(at.ordinal() == code) {
                type = at;
                break;
            }
        }
        return type;
    }

}
