package com.adarviroh.volunteerhub.been.type;

/**
 * Created by Yaraslau_Dubovik on 03/01/2024
 */
public enum UserType {
    GUEST, ADMIN, USER, COMMERCE_USER;

    public static UserType getType(int code) {
        UserType type = UserType.GUEST;
        for(UserType ut : UserType.values()) {
            if(ut.ordinal() == code) {
                type = ut;
                break;
            }
        }
        return type;
    }
}
