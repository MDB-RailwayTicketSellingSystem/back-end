package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Passenger;
import com.company.project.service.PassengerService;
import com.company.project.service.impl.PassengerServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
* Created by CodeGenerator on 2018/12/03.
*/
@RestController
@RequestMapping("/passenger")
public class PassengerController {
    @Resource
    private PassengerService passengerServiceImpl;
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {

        //转换日期
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }

    @PostMapping("/add")
    public Result add(Passenger passenger) {
        passengerServiceImpl.save(passenger);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        passengerServiceImpl.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Passenger passenger) {
        passengerServiceImpl.update(passenger);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        Passenger passenger = passengerServiceImpl.findById(id);
        return ResultGenerator.genSuccessResult(passenger);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Passenger> list = passengerServiceImpl.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /*
    用户登录
     */
    @GetMapping("/login")
    public Result login(@RequestParam(value = "name") String username,
                        @RequestParam(value = "password")String password){

        boolean isValidUser=passengerServiceImpl.haveMatchCount(username,password,0);
        if(!isValidUser)return ResultGenerator.genFailResult("错误！!");
        else
        {
            Passenger passenger=passengerServiceImpl.findPassenger(username,password,0);
            return ResultGenerator.genSuccessResult(passenger.getAccountid());
        }
    }


}
