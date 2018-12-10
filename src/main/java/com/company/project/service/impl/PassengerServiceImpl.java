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




/**
 * Created by CodeGenerator on 2018/12/03.
 */
@Service
@Transactional
public class PassengerServiceImpl extends AbstractService<Passenger> implements PassengerService {

    PassengerMapper passengerMapper;

    @Override
    public int addUser(String name,String password){
        Passenger passengernew=new Passenger();
        passengernew.setName(name);
        passengernew.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));//密码加密
       // passengernew.setAccounttype();
       // passengernew.setEmail();
       // passengernew.setPhone();
        passengerMapper.addPassenger(passengernew);
        return 1;


    }

    @Override
    public Passenger findPassengerByName(String name){
        Passenger passenger=new Passenger();
        passenger=passengerMapper.findByName(name);
        return passenger;
    }

    @Override
    public boolean haveMatchCount(String username,String password){
        return passengerMapper.getMatchCount(username,password)>0;
    }


}
