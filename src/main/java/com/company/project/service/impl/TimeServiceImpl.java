package com.company.project.service.impl;


import com.company.project.dao.TimeDAO;
import com.company.project.model.Seatting;
import com.company.project.model.Time;
import com.company.project.model.TimeSeatting;
import com.company.project.model.TrainResult;
import com.company.project.service.TimeService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/12/03.
 */
@Service
@Transactional
public class TimeServiceImpl extends AbstractService<Time> implements TimeService {
    @Resource
    private TimeDAO timeDAO;

    @Override
    public int getDuration (String trainnumber, int startOrder, int arriveOrder){
        int duration = 0;
        for( int stationorder = startOrder+1; stationorder < arriveOrder; stationorder++ ){

            duration = duration + timeDAO.findDuration(trainnumber, stationorder);
        }
        return duration;
    }

    /*
    查询列车
     */
    @Override
    public List<TrainResult> searchTrain(Date date, String start, String arrive){

        List<TrainResult> result = timeDAO.findTrain(date, start, arrive);

        return result;
    }

    /*
    用Timeseat表查询列车
     */
    @Override
    public List<TrainResult> searchTrainEasy(Date date, String start, String arrive){

        List<TrainResult> result = timeDAO.findTrainEasy(date, start, arrive);

        return result;
    }

    /*
    查询剩余座位
     */
    @Override
    public int isTicketLeft(String trainnumber, Date traindate, int stationorder){
        int num = timeDAO.findRemainSeat(trainnumber, traindate, stationorder);
        return num;
    }


    public Time time(){
/*
        TimeSeatting time=new TimeSeatting();
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
        time.setRemainingseat(Short.valueOf("12"));
        timeDAO.insert(time);
        return time;
        */
return new Time();
    }


}
