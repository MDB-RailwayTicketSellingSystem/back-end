package com.company.project.service;


import com.company.project.core.Service;
import com.company.project.model.Trainorder;

import java.time.LocalDate;
import java.util.Map;


public interface AdminService extends Service<Trainorder> {



    Map<LocalDate,Object> findbyTime(LocalDate start, LocalDate end, int status);

}
