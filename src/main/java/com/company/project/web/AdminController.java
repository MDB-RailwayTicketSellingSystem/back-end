package com.company.project.web;


import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Passenger;
import com.company.project.service.AdminService;
import com.company.project.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminServiceImpl;

    @Autowired
    PassengerService passengerServiceImpl;


    /*
    管理员登录
     */
    @GetMapping(value = "/login")
    public Result adminLogin(@RequestParam String name,
                             @RequestParam String password){
        boolean isValidUser=passengerServiceImpl.haveMatchCount(name,password,0);
        if(!isValidUser)return ResultGenerator.genFailResult("错误！!");
        else
        {
            Passenger passenger=passengerServiceImpl.findPassenger(name,password,0);
            return ResultGenerator.genSuccessResult(passenger.getAccountid());
        }
    }

    /*
    获取某段时间的新增订单数
     */
    @GetMapping(value = "/addCount")
    public Result getAddCountPerDay(@RequestParam LocalDate start,
                                    @RequestParam LocalDate end,
                                    @RequestParam int status){
        Map<LocalDate,Object> map=adminServiceImpl.findbyTime(start,end,status);
        return ResultGenerator.genSuccessResult(map);
    }



}
