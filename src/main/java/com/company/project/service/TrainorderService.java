package com.company.project.service;
import com.company.project.model.Trainorder;
import com.company.project.core.Service;

import java.time.LocalDate;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/12/03.
 */
public interface TrainorderService extends Service<Trainorder> {

    public List<Trainorder> getOrderByTime(LocalDate time);
}
