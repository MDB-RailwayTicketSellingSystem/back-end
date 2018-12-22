package com.company.project.service.impl;

import com.company.project.dao.TimeMapper;
import com.company.project.model.Time;
import com.company.project.service.TimeService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by CodeGenerator on 2018/12/03.
 */
@Service
@Transactional
public class TimeServiceImpl extends AbstractService<Time> implements TimeService {
    @Resource
    private TimeMapper timeMapper;


    public Time time(){
        Time time=new Time();
        Date date=new Date();
        time.setArrivetime(new Date());
        Calendar c=Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE,-2);
        time.setLeavetime(c.getTime());
        time.setTrainnumber("3");
        time.setArrivetime(date);
        time.setDuration(c.getTime());
        time.setStation("2");
        time.setStationorder(new BigDecimal(1));
        time.setTraindate(date);
        time.setRemainingseat(new BigDecimal(12));
        timeMapper.insert(time);
        return time;
    }


}
