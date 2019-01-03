package com.company.project.service.impl;

import com.company.project.dao.TimeDAO;
import com.company.project.dao.TrainorderDAO;
import com.company.project.model.Trainorder;
import com.company.project.service.TrainorderService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/12/03.
 */
@Service
@Transactional
public class TrainorderServiceImpl extends AbstractService<Trainorder> implements TrainorderService {
    @Resource
    private TrainorderDAO trainorderDAO;
    private TimeDAO timeDAO;


    /*
    查询历史订票
     */
    @Override
    public List<Trainorder> findHistoryOrder(String accountid, Date start, Date end) {

        List<Trainorder> result = trainorderDAO.findOrder(accountid, start, end);

        return result;
    }

    /*
    订票
     */
    @Override
    public boolean createOrder(String accountid, String trainnumber, LocalDate traindate, String startlocation, String arrivelocation, String name, String card){
        try{
            Trainorder order = new Trainorder();
            order.setAccountid(accountid);
            order.setTrainnumber(trainnumber);
            order.setTraindate(traindate);
            order.setStartlocation(startlocation);
            order.setArrivelocation(arrivelocation);
            order.setPrice(BigDecimal.valueOf(100));
            order.setState(BigDecimal.valueOf(0));
            order.setOrdertime(LocalDate.now());
            order.setName(name);
            order.setPassengercard(card);
            order.setOrderid( accountid + LocalDate.now().toString() ); //订单ID：用户ID+下单时间
            save(order);

            return true;
        } catch (Exception e){
            return false;
        }

    }

    /*
    取消订单
     */
    @Override
    public boolean cancelOrder(String orderid){
        try{
            Trainorder order = findById(orderid);
            order.setState(BigDecimal.valueOf(2));

            update(order);

            return true;
        }catch (Exception e){
            return false;
        }
    }


    /*
    获取某一天的所有订单
     */
    @Override
    public List<Trainorder> getOrderByTime(LocalDate time){
        List<Trainorder> orders= trainorderDAO.selectAll();
        List<Trainorder> dayorders=new LinkedList<>();
        for (Trainorder trainorder:orders){
            if(trainorder.getTraindate().equals(time)){
                dayorders.add(trainorder);
            }
        }
        return dayorders;
    }

}
