package com.company.project.service.impl;

import com.company.project.dao.TimeDAO;
import com.company.project.dao.TrainorderDAO;
import com.company.project.model.OrderResult;
import com.company.project.model.Trainorder;
import com.company.project.service.TrainorderService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


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
    public List<OrderResult> findHistoryOrder(String accountid, Date start, Date end) {


        List<OrderResult> result = trainorderDAO.findOrder(accountid, start, end);

        return result;
    }

    /*
    订票
     */
    @Override
    public boolean createOrder(String accountid, String trainnumber, Date traindate, int startOrder, int arriveOrder, String name, String card){

            Trainorder order = new Trainorder();
            order.setAccountid(accountid);
            order.setTrainnumber(trainnumber);
            order.setTraindate(traindate);
            order.setStartorder(startOrder);
            order.setArriveorder(arriveOrder);
            order.setPrice( 50 * (arriveOrder - startOrder) );
            order.setState(0);
            order.setOrdertime(new Date());
            order.setName(name);
            order.setPassengercard(card);
            order.setOrderid( accountid + new Date().toString() ); //订单ID：用户ID+下单时间
            save(order);

            //System.out.println(order.getAccountid());
            return true;
    }

    /*
    取消订单
     */
    @Override
    public boolean cancelOrder(String orderid){
        try{
            Trainorder order = findById(orderid);
            order.setState(2);

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
    public List<Trainorder> getOrderByTime(Date time){
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
