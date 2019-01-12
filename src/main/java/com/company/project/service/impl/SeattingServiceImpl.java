package com.company.project.service.impl;

import com.company.project.core.AbstractService;
import com.company.project.dao.SeattingDAO;
import com.company.project.model.Seatting;
import com.company.project.service.SeattingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/01/12.
 */
@Service
@Transactional
public class SeattingServiceImpl extends AbstractService<Seatting> implements SeattingService {
    @Resource
    private SeattingDAO seattingDAO;

}
