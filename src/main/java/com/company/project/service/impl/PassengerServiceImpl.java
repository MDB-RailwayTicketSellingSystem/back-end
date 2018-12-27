package com.company.project.service.impl;

import com.company.project.dao.PassengerDAO;
import com.company.project.model.Passenger;
import com.company.project.service.PassengerService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/12/03.
 */
@Service
@Transactional
public class PassengerServiceImpl extends AbstractService<Passenger> implements PassengerService {

    @Resource
    PassengerDAO passengerMapper;


    @Override
    public Passenger findPassenger(String name,String password,int type){
        Passenger passenger=new Passenger();
        passenger.setName(name);
        passenger.setPassword(password);
        passenger.setAccounttype(type);
        Passenger need=passengerMapper.selectOne(passenger);
        return need;
    }

    @Override
    public boolean haveMatchCount(String username,String password,int type){
        Passenger passenger=new Passenger();
        passenger.setName(username);
        passenger.setPassword(password);
        passenger.setAccounttype(type);
        int result=passengerMapper.selectCount(passenger);
        if(result==0) return false;
        else
            return true;

    }


}
