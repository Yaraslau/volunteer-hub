package com.adarviroh.volunteerhub;

import com.adarviroh.volunteerhub.been.Activity;
import com.adarviroh.volunteerhub.been.Event;
import com.adarviroh.volunteerhub.common.CommonConstant;
import com.adarviroh.volunteerhub.config.ApplicationConfig;
import com.adarviroh.volunteerhub.facade.GuestFacade;
import com.adarviroh.volunteerhub.util.MenuUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Yaraslau_Dubovik on 3/1/2024.
 */
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        GuestFacade guestFacade = context.getBean(GuestFacade.class);

        Scanner scanner = new Scanner(System.in);

        MenuUtil.greeting(CommonConstant.USER_TYPE_GUEST);

        int item;
        while(true) {
            // Guest Menu
            MenuUtil.guestStartMenu();
            item = getSelectedOption(scanner);
            switch(item) {
                case CommonConstant.REGISTRATION_VALUE: {
                    MenuUtil.registrationMenu();
                    break;
                }
                case CommonConstant.LOGIN_VALUE: {
                    MenuUtil.loginMenu();
                    break;
                }
                case CommonConstant.SEE_EVENTS_VALUE: {
                    List<Event> events = guestFacade.getAllEvents();
                    MenuUtil.seeAllEvents(events);
                    item = getSelectedOption(scanner);
                    if(item != -1) {
                        List<Activity> activities = guestFacade.getEventActivities(item);
                        long selectedEventId = item;
                        MenuUtil.seeEventActivities(events.stream()
                                .filter(e -> e.getId() == selectedEventId)
                                .findAny()
                                .orElse(new Event()), activities);
                        scanner.nextLine();
                    }
                    break;
                }
                case CommonConstant.EXIT_VALUE: {
                    ((AnnotationConfigApplicationContext) context).close();
                    return;
                }
                default: {
                    MenuUtil.incorrectChoice();
                }
            }
        }

    }

    private static int getSelectedOption(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }
}