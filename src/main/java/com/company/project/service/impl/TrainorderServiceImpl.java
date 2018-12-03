package com.company.project.service.impl;

import com.company.project.dao.TrainorderMapper;
import com.company.project.model.Trainorder;
import com.company.project.service.TrainorderService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/12/03.
 */
@Service
@Transactional
public class TrainorderServiceImpl extends AbstractService<Trainorder> implements TrainorderService {
    @Resource
    private TrainorderMapper trainorderMapper;

}
