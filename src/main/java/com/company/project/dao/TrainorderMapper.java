package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.Trainorder;

import java.time.LocalDate;
import java.util.List;

public interface TrainorderMapper extends Mapper<Trainorder> {

     List<Trainorder> getOrderByTime(LocalDate time);


}