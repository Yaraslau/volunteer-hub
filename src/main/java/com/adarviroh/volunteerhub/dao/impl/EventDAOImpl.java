package com.adarviroh.volunteerhub.dao.impl;

import com.adarviroh.volunteerhub.been.Event;
import com.adarviroh.volunteerhub.dao.EventDAO;
import com.adarviroh.volunteerhub.util.DataUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Yaraslau_Dubovik on 03/03/2024
 */
@Repository
public class EventDAOImpl implements EventDAO {

    @Override
    public List<Event> getAllEvents() {
        return DataUtil.fetchEvents();
    }
}
