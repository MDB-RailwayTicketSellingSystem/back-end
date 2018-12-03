package com.company.project.service.impl;

import com.company.project.dao.TimeMapper;
import com.company.project.model.Time;
import com.company.project.service.TimeService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/12/03.
 */
@Service
@Transactional
public class TimeServiceImpl extends AbstractService<Time> implements TimeService {
    @Resource
    private TimeMapper timeMapper;

}
