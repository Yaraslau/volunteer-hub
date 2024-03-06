package com.adarviroh.volunteerhub.facade;

import com.adarviroh.volunteerhub.been.Activity;
import com.adarviroh.volunteerhub.been.Event;
import com.adarviroh.volunteerhub.service.ActivityService;
import com.adarviroh.volunteerhub.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by Yaraslau_Dubovik on 03/03/2024
 */
@Controller
public class GuestFacade {

    private final EventService eventService;
    private final ActivityService activityService;

    @Autowired
    public GuestFacade(EventService eventService, ActivityService activityService) {
        this.eventService = eventService;
        this.activityService = activityService;
    }

    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    public List<Activity> getEventActivities(long eventId) {
        return activityService.getEventActivities(eventId);
    }
}
