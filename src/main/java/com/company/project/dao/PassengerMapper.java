package com.company.project.dao;

import com.company.project.model.Passenger;
import com.company.project.model.Time;
import org.apache.ibatis.annotations.Insert;
import com.company.project.core.Mapper;
import com.company.project.model.Time;


public interface PassengerMapper extends Mapper<Passenger> {

    public String TABLE_NAME = " Passenger ";
    public String INSERT_FIELDS = " username, password";

  //  @Insert({"insert into ",TABLE_NAME," ( ",INSERT_FILEDS," ) values (#{username}, #{password}"})
    int addPassenger(Passenger passenger);

    Passenger findByName(String name);

    int getMatchCount(String name,String password);







}