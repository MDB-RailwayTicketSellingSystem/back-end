package com.company.project.service;
import com.company.project.model.Trainorder;
import com.company.project.core.Service;


import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2018/12/03.
 */
public interface TrainorderService extends Service<Trainorder> {

    public List<Trainorder> getOrderByTime(Date time);
    List<Trainorder> findHistoryOrder(String accountid, Date start, Date end);
    boolean createOrder(String accountid, String trainnumber, Date traindate, int startOrder, int arriveOrder, String name, String card);
    boolean cancelOrder(String orderid);
}
