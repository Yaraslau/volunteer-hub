package com.adarviroh.volunteerhub.service;

import com.adarviroh.volunteerhub.been.Activity;

import java.util.List;

/**
 * Created by Yaraslau_Dubovik on 03/03/2024
 */
public interface ActivityService {

    List<Activity> getEventActivities(long eventId);

}
