package com.adarviroh.volunteerhub.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yaraslau_Dubovik on 03/03/2024
 */
@Component
@Aspect
public class CountingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountingAspect.class);

    private static final Map<Long, Integer> countEventMap = new HashMap<>();

    @Pointcut("@annotation(Countable)")
    public void executeCountingEvents() {
    }

    @Before("executeCountingEvents()")
    public void incrementCount(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if(args != null && args.length > 0) {
            long eventId = (long) args[0];
            int count = 1;
            if(countEventMap.containsKey(eventId)) {
                count = countEventMap.get(eventId);
                count++;
            }
            countEventMap.put(eventId, count);
            StringBuilder message = new StringBuilder("Currently events were chosen:");
            countEventMap.forEach((key, value) ->
                    message.append(" event #").append(key).append(" - ").append(value).append(" times;"));
            LOGGER.info(message.toString());
        }

    }

}
