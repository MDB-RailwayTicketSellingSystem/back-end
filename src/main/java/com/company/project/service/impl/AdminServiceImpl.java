package com.company.project.service.impl;

import com.company.project.core.AbstractService;
import com.company.project.dao.AdminMapper;
import com.company.project.model.Passenger;
import com.company.project.model.Trainorder;
import com.company.project.service.AdminService;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.apache.ibatis.ognl.OgnlContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class AdminServiceImpl extends AbstractService<Trainorder> implements AdminService {

    @Resource
    AdminMapper adminMapper;


    /*
    两个日期之间每一天的订单数量
     */
    @Autowired
    public Map<LocalDate,Object> findbyTime(LocalDate start, LocalDate end, int status) {
        Map<LocalDate,Object> map=new HashMap<LocalDate, Object>();
        long between=start.until(end, ChronoUnit.DAYS);//相差天数
        int bet=Integer.parseInt(String.valueOf(between));
        for(int i=0;i<bet;i++){
            LocalDate current=start.plus(i, ChronoUnit.DAYS);
            map.put(current,adminMapper.orderCountPerDay(current,status));
        }
        return map;
    }
}
