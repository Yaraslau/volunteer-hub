package com.adarviroh.volunteerhub.dao;

import com.adarviroh.volunteerhub.been.Activity;

import java.util.List;

/**
 * Created by Yaraslau_Dubovik on 03/03/2024
 */
public interface ActivityDAO {

    List<Activity> getEventActivities(long eventId);

}
