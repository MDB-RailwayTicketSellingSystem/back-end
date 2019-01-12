package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.Trainorder;

import java.util.Date;
import java.util.List;

public interface TrainorderDAO extends Mapper<Trainorder> {

     int getOrderByTimeSQL(Trainorder trainorder);//获取某天的订单数量
     List<Trainorder> findOrder(String accountid, Date start, Date end);


}