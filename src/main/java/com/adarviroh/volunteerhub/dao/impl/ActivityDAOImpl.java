package com.adarviroh.volunteerhub.dao.impl;

import com.adarviroh.volunteerhub.been.Activity;
import com.adarviroh.volunteerhub.dao.ActivityDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Yaraslau_Dubovik on 03/03/2024
 */
@Repository
public class ActivityDAOImpl implements ActivityDAO {

    private final EntityManager entityManager;

    @Autowired
    public ActivityDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Activity> getEventActivities(long eventId) {
        return  entityManager.createQuery("from Activity a where a.event.id = :eventId")
                       .setParameter("eventId", eventId)
                       .getResultList();
    }
}
