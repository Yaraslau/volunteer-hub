package com.adarviroh.volunteerhub.util;

import com.adarviroh.volunteerhub.been.Activity;
import com.adarviroh.volunteerhub.been.Entity;
import com.adarviroh.volunteerhub.been.Event;
import com.adarviroh.volunteerhub.been.User;
import com.adarviroh.volunteerhub.been.type.ActivityType;
import com.adarviroh.volunteerhub.been.type.EventType;
import com.adarviroh.volunteerhub.been.type.UserType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;

/**
 * Created by Yaraslau_Dubovik on 03/01/2024
 */
public class DataUtil {

    private static final String PATH = "src/main/resources/";
    private static final String ATTR_SEPARATOR = " ";

    private static <T> List<T> fetchData(String fileName, Function<String[], T> mapper) {
        String file = PATH + fileName;
        List<T> items = new ArrayList<>();
        try {
            Files.lines(Paths.get(file)).forEach(line -> {
                String[] attr = line.split(ATTR_SEPARATOR);
                items.add(mapper.apply(attr));
            });
        } catch(IOException e) {
            e.printStackTrace();
        }
        return items;
    }

    public static List<User> fetchUsers() {
        return fetchData("users.txt", attr -> {
            long id = Long.parseLong(attr[0]);
            String name = attr[1];
            String password = attr[2];
            int typeCode = Integer.parseInt(attr[3]);
            UserType type = UserType.getType(typeCode);
            return new User(id, name, password, type);
        });
    }

    public static List<Event> fetchEvents() {
        return fetchData("events.txt", attr -> {
            long id = Long.parseLong(attr[0]);
            String name = attr[1];
            int typeCode = Integer.parseInt(attr[2]);
            EventType type = EventType.getType(typeCode);
            long ownerId = Long.parseLong(attr[3]);
            User owner = getValue(fetchUsers(), ownerId).orElse(new User());
            return new Event(id, name, type, owner);
        });
    }

    public static List<Activity> fetchActivities() {
        return fetchData("activities.txt", attr -> {
            long id = Long.parseLong(attr[0]);
            long eventId = Long.parseLong(attr[1]);
            Event event = getValue(fetchEvents(), eventId).orElse(new Event());
            String name = attr[2];
            int typeCode = Integer.parseInt(attr[3]);
            ActivityType type = ActivityType.getType(typeCode);
            int demand = Integer.parseInt(attr[4]);
            int capacity = Integer.parseInt(attr[5]);
            int salary = Integer.parseInt(attr[6]);
            return new Activity(id, name, event, type, demand, capacity, salary);
        });
    }

    private static <T extends Entity> Optional<T> getValue(List<T> values, long id) {
        return values.stream().filter(v -> v.getId() == id)
                .findFirst();
    }
}
