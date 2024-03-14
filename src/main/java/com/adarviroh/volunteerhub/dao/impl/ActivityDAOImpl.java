package com.adarviroh.volunteerhub.dao.impl;

import com.adarviroh.volunteerhub.been.Activity;
import com.adarviroh.volunteerhub.been.Event;
import com.adarviroh.volunteerhub.been.type.ActivityType;
import com.adarviroh.volunteerhub.dao.ActivityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Yaraslau_Dubovik on 03/03/2024
 */
@Repository
public class ActivityDAOImpl implements ActivityDAO {

    private final static String GET_ALL_BY_EVENT_ID = "SELECT * FROM APP.ACTIVITY A WHERE A.EVENT_ID = ?";

    private final RowMapper<Activity> matchRowMapper = (rs, i) -> {
      Activity activity = new Activity();
      activity.setId(rs.getLong("ID"));
      activity.setName(rs.getString("NAME"));
      activity.setType(ActivityType.getType(rs.getInt("TYPE")));
      activity.setDemand(rs.getInt("DEMAND"));
      activity.setCapacity(rs.getInt("CAPACITY"));
      activity.setSalary(rs.getInt("SALARY"));
      Event event = new Event();
      event.setId(rs.getLong("EVENT_ID"));
      activity.setEvent(event);
      return activity;
    };

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ActivityDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Activity> getEventActivities(long eventId) {
        return  jdbcTemplate.query(GET_ALL_BY_EVENT_ID, new Object[]{eventId}, matchRowMapper);
    }
}
