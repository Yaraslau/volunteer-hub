package com.adarviroh.volunteerhub.been.type;

/**
 * Created by Yaraslau_Dubovik on 03/01/2024
 */
public enum EventType {
    COMMON, COMMERCE;

    public static EventType getType(int code) {
        EventType type = EventType.COMMON;
        for(EventType et : EventType.values()) {
            if(et.ordinal() == code) {
                type = et;
                break;
            }
        }
        return type;
    }
}
