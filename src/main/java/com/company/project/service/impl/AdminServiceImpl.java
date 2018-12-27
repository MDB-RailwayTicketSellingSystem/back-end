package com.company.project.service.impl;

import com.company.project.core.AbstractService;
import com.company.project.dao.PassengerDAO;
import com.company.project.dao.TrainorderDAO;
import com.company.project.model.Trainorder;
import com.company.project.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
@Transactional
public class AdminServiceImpl extends AbstractService<Trainorder> implements AdminService {

    @Resource
    private TrainorderDAO trainorderDAO;


    /*
    两个日期之间每一天的新增订单数量
     */
    @Override
    public Map<LocalDate,Object> findbyTime(LocalDate start, LocalDate end, int status)
    {
        Map<LocalDate,Object> map=new HashMap<LocalDate, Object>();
        long between=start.until(end, ChronoUnit.DAYS);//相差天数
        int bet=Integer.parseInt(String.valueOf(between));
        for(int i=0;i<bet;i++){
            LocalDate current=start.plusDays(i);
            Trainorder trainorder=new Trainorder();
            trainorder.setState(new BigDecimal(status));
            trainorder.setOrdertime(current);
            List<Trainorder> trainorders= trainorderDAO.select(trainorder);
            map.put(current,trainorders.size());

        }
        return map;
    }


}
