package com.adarviroh.volunteerhub.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Yaraslau_Dubovik on 03/03/2024
 */
@Configuration
@ComponentScan(basePackages = "com.adarviroh.volunteerhub")
@PropertySource({
        "classpath:application.properties",
        "classpath:hibernate.properties"
})
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class ApplicationConfig {

    @Value("${app.dbUrl}")
    private String dbUrl;

    @Value("${app.dbUser}")
    private String dbUser;

    @Value("${app.dbPassword}")
    private String dbPassword;

    @Value("${app.driverClassName}")
    private String driverClassName;

    @Value("${hibernate.model.path}")
    private String hibernateModelPath;

    @Value("${hibernate.hbm2ddl.auto}")
    private String hibernateHBM2DDL;

    @Value("${hibernate.dialect}")
    private String hibernateDialect;

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUser);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(hibernateModelPath);
        sessionFactory.setHibernateProperties(generateHibernateProperties());
        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    private Properties generateHibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", hibernateHBM2DDL);
        hibernateProperties.setProperty("hibernate.dialect", hibernateDialect);
        return hibernateProperties;
    }
}
