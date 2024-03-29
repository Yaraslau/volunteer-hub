package com.adarviroh.volunteerhub.dao.impl;

import com.adarviroh.volunteerhub.been.Event;
import com.adarviroh.volunteerhub.dao.EventDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Yaraslau_Dubovik on 03/03/2024
 */
@Repository
public class EventDAOImpl implements EventDAO {

    private final EntityManager entityManager;

    @Autowired
    public EventDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Event> getAllEvents() {
        return entityManager.createQuery("from Event").getResultList();
    }

}
