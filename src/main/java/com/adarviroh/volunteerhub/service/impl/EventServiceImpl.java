package com.adarviroh.volunteerhub.service.impl;

import com.adarviroh.volunteerhub.aspect.Loggable;
import com.adarviroh.volunteerhub.been.Event;
import com.adarviroh.volunteerhub.dao.EventDAO;
import com.adarviroh.volunteerhub.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yaraslau_Dubovik on 03/03/2024
 */
@Service
public class EventServiceImpl implements EventService {

    private final EventDAO eventDAO;

    @Autowired
    public EventServiceImpl(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    @Override
    @Loggable
    public List<Event> getAllEvents() {
        return eventDAO.getAllEvents();
    }

    @Override
    public Event getEvent(long eventId) {
        return eventDAO.getEvent(eventId);
    }
}
