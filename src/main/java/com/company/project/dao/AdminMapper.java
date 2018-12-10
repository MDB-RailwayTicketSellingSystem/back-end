package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.Time;

import java.time.LocalDate;
import java.util.Date;

public interface AdminMapper {

    int orderCountPerDay(LocalDate date,int state);//某一天的订单量




}
