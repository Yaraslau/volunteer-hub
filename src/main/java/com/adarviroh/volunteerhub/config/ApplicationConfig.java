package com.adarviroh.volunteerhub.config;


import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
    private String modelPath;

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
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSource());
        entityManager.setPackagesToScan(modelPath);
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManager.setJpaVendorAdapter(vendorAdapter);
        entityManager.setJpaProperties(generateHibernateProperties());
        return entityManager;
    }

    @Bean
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

    private Properties generateHibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", hibernateHBM2DDL);
        hibernateProperties.setProperty("hibernate.dialect", hibernateDialect);
        return hibernateProperties;
    }
}
