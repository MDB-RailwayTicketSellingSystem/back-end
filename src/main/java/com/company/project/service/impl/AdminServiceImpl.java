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
    public  List<Map<String,Object>> findbyTime(Date start, Date end, int status)
    {
        List<Map<String,Object>> list=new LinkedList<>();
        int between=(int) (end.getTime() - start.getTime());//相差天数

        for(int i=0;i<between;i++){
            Map<String,Object> map=new HashMap<String, Object>();
            Calendar c = Calendar.getInstance();
            c.setTime(start);
            c.add(Calendar.DAY_OF_MONTH, i);
            Date current= c.getTime();
            Trainorder trainorder=new Trainorder();
            trainorder.setState(status);
            trainorder.setOrdertime(current);
            int j= trainorderDAO.getOrderByTimeSQL(trainorder);
            map.put("date",current);
            map.put("count",j);
            list.add(map);

        }
        return list;
    }


}
