package com.adarviroh.volunteerhub.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Yaraslau_Dubovik on 03/03/2024
 */
@Configuration
@ComponentScan(basePackages = "com.adarviroh.volunteerhub")
@EnableAspectJAutoProxy
public class ApplicationConfig {
}
