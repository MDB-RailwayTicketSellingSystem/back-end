package com.company.project.dao;
import com.company.project.core.Mapper;
import com.company.project.model.Time;
import com.company.project.model.TrainResult;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import com.company.project.core.Mapper;
import com.company.project.model.Time;

public interface TimeDAO extends Mapper<Time> {

    int findDuration(@Param("trainnumber") String trainnumber, @Param("stationorder") int stationorder);
    List<TrainResult> findTrain(@Param("date") Date date, @Param("start") String start, @Param("arrive") String arrive);
    List<TrainResult> findTrainEasy(@Param("date") Date date, @Param("start") String start, @Param("arrive") String arrive);
    int findStationOrder(@Param("trainnumber") String trainnumber, @Param("station") String station);
    void sell(@Param("trainnumber") String trainnumber, @Param("traindate") Date traindate, @Param("startOrder") int startOrder, @Param("arriveOrder") int arriveOrder, @Param("num") int num); //卖出订单
    void back(@Param("trainnumber") String trainnumber, @Param("traindate") Date traindate, @Param("startOrder") int startOrder, @Param("arriveOrder") int arriveOrder, @Param("num") int num); //取消订单
    int findRemainSeat(@Param("trainnumber") String trainnumber, @Param("traindate") Date traindate, @Param("stationorder") int stationorder);

}