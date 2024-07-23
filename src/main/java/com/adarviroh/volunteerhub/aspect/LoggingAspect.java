package com.adarviroh.volunteerhub.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Yaraslau_Dubovik on 03/03/2024
 */
@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("@annotation(Loggable)")
    public void executeLogging() {
    }

    @Around(value = "executeLogging()")
    public Object logMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
        StringBuilder message = new StringBuilder("Method: ")
                .append(joinPoint.getSignature().getName())
                .append(" was called");
        Object[] args = joinPoint.getArgs();
        if(args != null && args.length > 0) {
            message.append(" with next args: ");
            Arrays.asList(args).forEach(arg -> message.append(arg).append("; "));
        } else {
            message.append(" without args.");
        }
        LOGGER.info(message.toString());
        return joinPoint.proceed();
    }

}
