package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.Time;
import jdk.vm.ci.meta.Local;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TimeDAO extends Mapper<Time> {

    List<Time> findTrain(Date date, String start, String end);
    BigDecimal findStationOrder(String trainnumber, LocalDate traindate, String station);
    void sell(String trainnumber, LocalDate traindate, BigDecimal startOrder, BigDecimal arriveOrder, int num); //卖出订单
    void back(String trainnumber, LocalDate traindate, BigDecimal startOrder, BigDecimal arriveOrder, int num); //取消订单
    BigDecimal findRemainSeat(String trainnumber, LocalDate traindate, BigDecimal stationorder);

}