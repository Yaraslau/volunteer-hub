package com.adarviroh.volunteerhub.util;

import com.adarviroh.volunteerhub.been.Activity;
import com.adarviroh.volunteerhub.been.Event;
import com.adarviroh.volunteerhub.common.CommonConstant;

import java.util.List;

/**
 * Created by Yaraslau_Dubovik on 03/01/2024
 */
public class MenuUtil {

    public static void greeting(String name) {
        menuBorder();
        System.out.println("Hello, " + name + "!");
    }
    public static void guestStartMenu() {
        menuBorder();
        System.out.println("Choose any menu option and press enter:");
        System.out.println(CommonConstant.REGISTRATION);
        System.out.println(CommonConstant.LOGIN);
        System.out.println(CommonConstant.EVENTS);
        System.out.println(CommonConstant.EXIT);
        menuBorder();
    }

    public static void registrationMenu() {
        comingSoon();
    }

    public static void loginMenu() {
        comingSoon();
    }

    public static void seeAllEvents(List<Event> events) {
        menuBorder();
        System.out.println("If you want to see more info about event, then put event id and press enter");
        menuBorder();
        events.forEach(event -> System.out.println("ID:" + event.getId() + " " + event.getName()));
        menuBorder();
        backToMainMenuOption();
        menuBorder();
    }

    public static void seeEventActivities(Event event, List<Activity> activities) {
        menuBorder();
        System.out.println("Event: " + event.getName());
        System.out.println("Owner: " + event.getOwner().getName());
        System.out.println("Event ID: " + event.getId());
        System.out.println("Event Activities:");
        menuBorder();
        activities.forEach(activity -> System.out.println(activity.getName()
                + " Demand:" + activity.getDemand()
                + " Available:" + (activity.getDemand() - activity.getCapacity() > 0 ? activity.getDemand() - activity.getCapacity() : 0)
                + " Paid:" + (activity.getSalary() > 0 ? activity.getSalary() : "NO")
            )
        );
        menuBorder();
        pressAnyToBackToMainMenu();
        menuBorder();
    }

    public static void incorrectChoice() {
        menuBorder();
        System.out.println("Please put correct number and press enter");
    }

    private static void comingSoon() {
        menuBorder();
        System.out.println("Sorry, but this feature will be implemented as soon a possible!");
        System.out.println("Please, chose another menu option and press enter");
    }

    private static void backToMainMenuOption() {
        System.out.println("-1 - back to main menu");
    }

    private static void pressAnyToBackToMainMenu() {
        System.out.println("Press any key and press enter to back to main menu");
    }

    private static void menuBorder() {
        System.out.println("------------------------------------------------------------------");
    }

}
