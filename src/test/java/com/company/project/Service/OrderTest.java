package com.company.project.Service;

import com.company.project.dao.TrainorderDAO;
import com.company.project.model.Trainorder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTest {

    @Resource
    TrainorderDAO trainorderDAO;

    @Test
    public void test(){
        LocalDate localDate=LocalDate.of(2018,12,23);
        Trainorder trainorder=new Trainorder();
        trainorder.setOrdertime(localDate);
        trainorder.setState(new BigDecimal(0));
        int i=trainorderDAO.getOrderByTimeSQL(trainorder);
        System.out.println(i+"value");
    }

}
