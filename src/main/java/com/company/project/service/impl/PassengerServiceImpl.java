package com.company.project.service.impl;

import com.company.project.dao.PassengerMapper;
import com.company.project.model.Passenger;
import com.company.project.service.PassengerService;
import com.company.project.core.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;


/**
 * Created by CodeGenerator on 2018/12/03.
 */
@Service
@Transactional
public class PassengerServiceImpl extends AbstractService<Passenger> implements PassengerService {

    PassengerMapper passengerMapper;


    @Override
    public Passenger findPassenger(String name,String password,int type){
        Passenger passenger=new Passenger();
        passenger.setName(name);
        passenger.setPassword(password);
        BigDecimal accounttype=new BigDecimal(type);
        passenger.setAccounttype(accounttype);
        Passenger need=passengerMapper.selectOne(passenger);

        return need;
    }

    @Override
    public boolean haveMatchCount(String username,String password,int type){
        Passenger passenger=new Passenger();
        passenger.setName(username);
        passenger.setPassword(password);
        BigDecimal accounttype=new BigDecimal(type);
        passenger.setAccounttype(accounttype);
        int result=passengerMapper.selectCount(passenger);
        if(result==0) return false;
        else return true;

    }


}
