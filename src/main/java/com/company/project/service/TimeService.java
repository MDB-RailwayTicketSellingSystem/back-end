package com.company.project.service;
import com.company.project.model.Time;
import com.company.project.core.Service;
import jdk.vm.ci.meta.Local;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/12/03.
 */
public interface TimeService extends Service<Time> {

    List<Time> searchTrain(Date date, String start, String arrive);
    boolean isTicketLeft(String trainnumber, LocalDate traindate, int stationorder);

}
