package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.OrderResult;
import com.company.project.model.Time;
import com.company.project.model.TrainResult;
import com.company.project.service.TimeService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
* Created by CodeGenerator on 2018/12/03.
*/
@RestController
@RequestMapping("/time")
public class TimeController {
    @Resource
    private TimeService timeService;
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {

        //转换日期
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }

    //@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @GetMapping("/findTrain")
    public List<TrainResult> searchTrain(@RequestParam("date") Date date, @RequestParam("start") String start, @RequestParam("arrive")String arrive) {

        List<TrainResult> trainResults=timeService.searchTrain(date, start, arrive);
        for (TrainResult train:trainResults) {

            train.traindateresult = train.formatter.format(train.traindate);
            train.arrivetimeresult = train.formatter.format(train.arrivetime);
            train.leavetimeresult = train.formatter.format(train.leavetime);
            train.durationresult = train.formatter.format(train.duration);

            train.price = 50 * (train.arriveorder - train.startorder);

        }

        return trainResults;
    }

    @PostMapping("/add")
    public Result add(Time time) {
        timeService.save(time);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        timeService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Time time) {
        timeService.update(time);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Time time = timeService.findById(id);
        return ResultGenerator.genSuccessResult(time);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Time> list = timeService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
