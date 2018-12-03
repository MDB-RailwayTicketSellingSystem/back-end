package com.company.project.service.impl;

import com.company.project.dao.PassengerMapper;
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
    private PassengerMapper passengerMapper;


}
