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

import java.text.SimpleDateFormat;
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
        int between=(int) (end.getTime() - start.getTime())/ 1000 / 60 / 60 / 24;//相差天数
      //  System.out.println("cccc" + between);
        for(int i=0;i<=between;i++){
            Map<String,Object> map=new HashMap<String, Object>();
            Calendar c = Calendar.getInstance();
            c.setTime(start);
            c.set(Calendar.HOUR_OF_DAY,0);
            c.set(Calendar.MINUTE,00);
            c.add(Calendar.DAY_OF_MONTH, i);
            Date current= c.getTime();
           // System.out.println("AAAAA" + current);
            Trainorder trainorder=new Trainorder();
            trainorder.setState(0);
            SimpleDateFormat sdf0 =new SimpleDateFormat( "yyyy-MM-dd HH:mm" );
            try {
                String newda=sdf0.format(current);
                //System.out.println("aaa" +newda);
                Date newnew=sdf0.parse(newda);
              //  System.out.println("bbb" +newnew);
                trainorder.setOrdertime(newnew);

            }catch (Exception e){

            }
            int j= trainorderDAO.getOrderByTimeSQL(trainorder);
            SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd" );
                map.put("date", sdf.format(current));
                map.put("count",j);
                list.add(map);

        }
        return list;
    }


}
