package com.company.project.service;
import com.company.project.model.Passenger;
import com.company.project.core.Service;


/**
 * Created by CodeGenerator on 2018/12/03.
 */
public interface PassengerService extends Service<Passenger> {


    Passenger findPassenger(String name,String password,int type);

    boolean haveMatchCount(String username,String password,int type);




}
