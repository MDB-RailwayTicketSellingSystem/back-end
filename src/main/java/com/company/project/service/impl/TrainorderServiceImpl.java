package com.company.project.service.impl;

import com.company.project.dao.TrainorderMapper;
import com.company.project.model.Trainorder;
import com.company.project.service.TrainorderService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/12/03.
 */
@Service
@Transactional
public class TrainorderServiceImpl extends AbstractService<Trainorder> implements TrainorderService {
    @Resource
    private TrainorderMapper trainorderMapper;

    /*
    获取某一天的所有订单
     */
    @Override
    public List<Trainorder> getOrderByTime(LocalDate time){
        List<Trainorder> orders=trainorderMapper.selectAll();
        List<Trainorder> dayorders=new LinkedList<>();
        for (Trainorder trainorder:orders){
            if(trainorder.getTraindate().equals(time)){
                dayorders.add(trainorder);
            }
        }
        return dayorders;
    }

}
