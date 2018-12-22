package com.company.project.service;


import com.company.project.core.Service;
import com.company.project.dao.PassengerMapper;
import com.company.project.model.Trainorder;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Map;


public interface AdminService extends Service<Trainorder> {



    Map<LocalDate,Object> findbyTime(LocalDate start, LocalDate end, int status);

}
