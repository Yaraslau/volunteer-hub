package com.adarviroh.volunteerhub.service;

import com.adarviroh.volunteerhub.been.Event;

import java.util.List;

/**
 * Created by Yaraslau_Dubovik on 03/03/2024
 */
public interface EventService {

    List<Event> getAllEvents();

    Event getEvent(long eventId);

}
