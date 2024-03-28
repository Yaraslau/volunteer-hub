package com.adarviroh.volunteerhub.dao.impl;

import com.adarviroh.volunteerhub.been.Activity;
import com.adarviroh.volunteerhub.dao.ActivityDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Yaraslau_Dubovik on 03/03/2024
 */
@Repository
public class ActivityDAOImpl implements ActivityDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public ActivityDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Activity> getEventActivities(long eventId) {
        Session session = sessionFactory.getCurrentSession();
        return  session.createQuery("from Activity a where a.event.id = :eventId")
                       .setParameter("eventId", eventId)
                       .list();
    }
}
