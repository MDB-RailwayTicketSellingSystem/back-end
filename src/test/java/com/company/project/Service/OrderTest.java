package com.company.project.Service;

import com.company.project.dao.TrainorderDAO;
import com.company.project.model.Trainorder;
import com.company.project.service.impl.PassengerServiceImpl;
import com.company.project.service.impl.TimeServiceImpl;
import com.company.project.service.impl.TrainorderServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    TrainorderServiceImpl timeServiceImpl = new TrainorderServiceImpl();

    @Test
    public void test4(){

        System.out.println(timeServiceImpl.cancelOrder("1"));
    }

    @Test
    public void test3(){

        LocalDate localDate=LocalDate.of(2018,12,20);
        System.out.println(timeServiceImpl.createOrder("1", "1", localDate, 1, 2, "张三2", "张三card" ));
    }

    @Test
    public void test(){
        LocalDate localDate=LocalDate.of(2018,12,20);
        Trainorder trainorder=new Trainorder();
        trainorder.setOrdertime(localDate);
        trainorder.setState(0);
        int i=trainorderDAO.getOrderByTimeSQL(trainorder);
        System.out.println(i+"value");
    }

    @Test
    public void test2(){
        LocalDate localDate=LocalDate.of(2018,12,23);
        //System.out.println(trainorderDAO.findOrder("3", localDate, localDate).size());
        System.out.println(trainorderDAO.findOrder("3", localDate, localDate));
    }


}
