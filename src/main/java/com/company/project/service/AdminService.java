package com.company.project.service;


import com.company.project.core.Service;
import com.company.project.model.Trainorder;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


public interface AdminService extends Service<Trainorder> {



    List<Map<String,Object>> findbyTime(LocalDate start, LocalDate end, int status);

}
