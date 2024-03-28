package com.adarviroh.volunteerhub.dao.impl;

import com.adarviroh.volunteerhub.been.Event;
import com.adarviroh.volunteerhub.dao.EventDAO;
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
public class EventDAOImpl implements EventDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public EventDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Event> getAllEvents() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Event").list();
    }

}
