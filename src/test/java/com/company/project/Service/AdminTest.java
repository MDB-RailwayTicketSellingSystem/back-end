package com.company.project.Service;

import com.company.project.model.Passenger;
import com.company.project.service.impl.PassengerServiceImpl;
import com.company.project.service.impl.TimeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminTest {
    @Autowired
    TimeServiceImpl timeService;

    @Autowired
    PassengerServiceImpl passengerService=new PassengerServiceImpl();

    @Test
    public void test(){
      Passenger result=passengerService.findById("2");
      if(result!=null){
          System.out.println(result.getName());
          System.out.println(result.getPassword());
          System.out.println(result.getAccounttype());
      }else {
          System.out.println("fff");
      }

    }

    @Test
    public void test2(){
      System.out.println(passengerService.haveMatchCount("管理员","admin",1)+"exist");
      System.out.println(passengerService.haveMatchCount("张三","ymir1226",0)+"exist");


        if(passengerService.findPassenger("管理员","admin",1)!=null){
            System.out.println("ok");
        }else {
            System.out.println("failure");
        };
    }
}
