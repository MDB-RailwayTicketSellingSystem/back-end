package com.company.project.service;
import com.company.project.dao.PassengerMapper;
import com.company.project.model.Passenger;
import com.company.project.core.Service;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by CodeGenerator on 2018/12/03.
 */
public interface PassengerService extends Service<Passenger> {

    int addUser(String name,String password);

    Passenger findPassengerByName(String name);

    boolean haveMatchCount(String username,String password);




}
