package com.adarviroh.volunteerhub.dao.impl;

import com.adarviroh.volunteerhub.been.Activity;
import com.adarviroh.volunteerhub.dao.ActivityDAO;
import com.adarviroh.volunteerhub.util.DataUtil;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Yaraslau_Dubovik on 03/03/2024
 */
@Repository
public class ActivityDAOImpl implements ActivityDAO {

    @Override
    public List<Activity> getEventActivities(long eventId) {
        return DataUtil.fetchActivities().stream()
                .filter(activity -> activity.getEvent().getId() == eventId)
                .collect(Collectors.toList());
    }
}
