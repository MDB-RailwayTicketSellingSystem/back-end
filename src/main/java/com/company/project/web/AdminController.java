package com.company.project.web;


import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Passenger;
import com.company.project.model.Time;
import com.company.project.service.AdminService;
import com.company.project.service.PassengerService;
import com.company.project.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminServiceImpl;

    @Autowired
    PassengerService passengerServiceImpl;

    @Autowired
    TimeService timeServiceImpl;

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {

        //转换日期
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }


    /*
    管理员登录
     */
    @GetMapping(value = "/login")
    public Result adminLogin(@RequestParam String name,
                             @RequestParam String password){
        boolean isValidUser=passengerServiceImpl.haveMatchCount(name,password,1);
        if(!isValidUser)return ResultGenerator.genFailResult("错??！!");
        else
        {
            Passenger passenger=passengerServiceImpl.findPassenger(name,password,1);
            return ResultGenerator.genSuccessResult(passenger.getAccountid());
        }
    }

    /*
    获取某段时间的新增订单数,状态数可输
     */
    @GetMapping(value = "/addCount")
    public Result getAddCountPerDay(@RequestParam Date start,
                                    @RequestParam Date  end,
                                    @RequestParam int status){

        if(start.compareTo(end)>0)
            return ResultGenerator.genFailResult("wrong input date!!!");
       // Map<LocalDate,Object> map=adminServiceImpl.findbyTime(beginDateTime,endDateTime,status);
        return ResultGenerator.genSuccessResult(adminServiceImpl.findbyTime(start,end,status));
    }

    @GetMapping(value = "/insert")
    public void test(){
        Time time=new Time();
        Date date=new Date();
        time.setArrivetime(new Date());
        Calendar c=Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE,-2);
        time.setLeavetime(c.getTime());

        timeServiceImpl.save(time);
    }


}
