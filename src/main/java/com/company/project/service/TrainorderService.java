package com.company.project.service;
import com.company.project.model.Trainorder;
import com.company.project.core.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/12/03.
 */
public interface TrainorderService extends Service<Trainorder> {

    public List<Trainorder> getOrderByTime(LocalDate time);
    List<Trainorder> findHistoryOrder(String accountid, Date start, Date end);
    boolean createOrder(String accountid, String trainnumber, LocalDate traindate, String startlocation, String arrivelocation, String name, String card);
    boolean cancelOrder(String orderid);
}
