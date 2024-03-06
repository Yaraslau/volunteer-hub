package com.adarviroh.volunteerhub.service.impl;

import com.adarviroh.volunteerhub.aspect.Countable;
import com.adarviroh.volunteerhub.aspect.Loggable;
import com.adarviroh.volunteerhub.been.Activity;
import com.adarviroh.volunteerhub.dao.ActivityDAO;
import com.adarviroh.volunteerhub.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yaraslau_Dubovik on 03/03/2024
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    private final ActivityDAO activityDAO;

    @Autowired
    public ActivityServiceImpl(ActivityDAO activityDAO) {
        this.activityDAO = activityDAO;
    }

    @Override
    @Loggable
    @Countable
    public List<Activity> getEventActivities(long eventId) {
        return activityDAO.getEventActivities(eventId);
    }
}
