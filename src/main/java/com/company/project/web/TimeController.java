package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Time;
import com.company.project.service.TimeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @GetMapping("/findTrain")
    public List<Time> searchTrain(@RequestParam("date") Date date, @RequestParam("start") String start, @RequestParam("arrive") String arrive) {


        return timeService.searchTrain(date, start, arrive);
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
