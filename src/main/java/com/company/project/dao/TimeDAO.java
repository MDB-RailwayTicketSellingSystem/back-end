package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.Time;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TimeDAO extends Mapper<Time> {

    List<Time> findTrain(@Param("date") LocalDate date, @Param("start") String start, @Param("end") String end);
    int findStationOrder(@Param("trainnumber") String trainnumber, @Param("traindate") LocalDate traindate, @Param("station") String station);
    void sell(@Param("trainnumber") String trainnumber, @Param("traindate") LocalDate traindate, @Param("startOrder") int startOrder, @Param("arriveOrder") int arriveOrder, @Param("num") int num); //卖出订单
    void back(@Param("trainnumber") String trainnumber, @Param("traindate") LocalDate traindate, @Param("startOrder") int startOrder, @Param("arriveOrder") int arriveOrder, @Param("num") int num); //取消订单
    int findRemainSeat(@Param("trainnumber") String trainnumber, @Param("traindate") LocalDate traindate, @Param("stationorder") int stationorder);

}