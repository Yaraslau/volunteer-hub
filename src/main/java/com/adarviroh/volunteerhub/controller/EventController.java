package com.adarviroh.volunteerhub.controller;

import com.adarviroh.volunteerhub.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Yaraslau_Dubovik on 04/16/2024
 */
@Controller
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/all")
    public String seeAllEvents(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "events";
    }

    @GetMapping("/get/{id}")
    public String getEventInfo(@PathVariable("id") long eventId, Model model) {
        model.addAttribute("event", eventService.getEvent(eventId));
        return "event";
    }

}
