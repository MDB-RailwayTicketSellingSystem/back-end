package com.company.project.service.impl;

import com.company.project.dao.TimeDAO;
import com.company.project.model.Time;
import com.company.project.service.TimeService;
import com.company.project.core.AbstractService;
import jdk.vm.ci.meta.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
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

    /*
    查询列车
     */
    @Override
    public List<Time> searchTrain(Date date, String start, String arrive){

        List<Time> result = timeDAO.findTrain(date, start, arrive);

        return result;
    }

    /*
    查询剩余座位
     */
    @Override
    public boolean isTicketLeft(String trainnumber, LocalDate traindate, int stationorder){
        BigDecimal count = timeDAO.findRemainSeat(trainnumber, traindate, stationorder);
        int num = count.intValue();
        if( num >= 1 ){
            return true;
        }
        else{
            return false;
        }
    }


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
        timeDAO.insert(time);
        return time;
    }


}
