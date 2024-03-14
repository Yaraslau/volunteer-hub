package com.adarviroh.volunteerhub.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by Yaraslau_Dubovik on 03/03/2024
 */
@Configuration
@ComponentScan(basePackages = "com.adarviroh.volunteerhub")
@PropertySource("classpath:application.properties")
@EnableAspectJAutoProxy
public class ApplicationConfig {

    @Value("${app.dbUrl}")
    private String dbUrl;

    @Value("${app.dbUser}")
    private String dbUser;

    @Value("${app.dbPassword}")
    private String dbPassword;

    @Value("${app.driverClassName}")
    private String driverClassName;

    @Autowired
    private DriverManagerDataSource dataSource;

    @Bean
    public DriverManagerDataSource dataSource() {
        return new DriverManagerDataSource(dbUrl, dbUser, dbPassword);
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }
}
