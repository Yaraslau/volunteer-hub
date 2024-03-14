package com.adarviroh.volunteerhub.dao.impl;

import com.adarviroh.volunteerhub.been.Event;
import com.adarviroh.volunteerhub.been.User;
import com.adarviroh.volunteerhub.been.type.EventType;
import com.adarviroh.volunteerhub.dao.EventDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Yaraslau_Dubovik on 03/03/2024
 */
@Repository
public class EventDAOImpl implements EventDAO {

    private final static String GET_ALL = "SELECT E.ID AS EVENT_ID, E.TYPE AS EVENT_TYPE, E.NAME AS EVENT_NAME, E.OWNER_ID, U.NAME AS OWNER_NAME " +
            "FROM APP.EVENT E " +
            "INNER JOIN APP.APP_USER U " +
            "ON U.ID = E.OWNER_ID " +
            "ORDER BY E.NAME";

    private final RowMapper<Event> matchRowMapper = (rs, i) -> {
        Event event = new Event();
        event.setId(rs.getLong("EVENT_ID"));
        event.setType(EventType.getType(rs.getInt("EVENT_TYPE")));
        event.setName(rs.getString("EVENT_NAME"));
        User owner = new User();
        owner.setId(rs.getLong("OWNER_ID"));
        owner.setName(rs.getString("OWNER_NAME"));
        event.setOwner(owner);
        return event;
    };

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EventDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Event> getAllEvents() {
        return jdbcTemplate.query(GET_ALL, matchRowMapper);
    }

}
