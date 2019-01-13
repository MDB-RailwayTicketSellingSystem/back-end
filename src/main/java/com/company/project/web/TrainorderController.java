package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.dao.TimeDAO;
import com.company.project.model.OrderResult;
import com.company.project.model.Passenger;
import com.company.project.model.Trainorder;
import com.company.project.service.PassengerService;
import com.company.project.service.TimeService;
import com.company.project.service.TrainorderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.Resource;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
* Created by CodeGenerator on 2018/12/03.
*/
@RestController
@RequestMapping("/trainorder")
public class TrainorderController {
    @Resource
    private TrainorderService trainorderService;
    @Resource
    private PassengerService passengerService;
    @Resource
    private TimeService timeService;
    @Resource
    private TimeDAO timeDAO;

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {

        //转换日期
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }


    @PostMapping("/findHistoryOrder")
    public List<OrderResult> findHistoryOrder(@RequestParam("accountid") String accountid, @RequestParam("start") Date start, @RequestParam("end") Date end) {
        List<OrderResult> orderResults=trainorderService.findHistoryOrder(accountid,start , end);
        //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        for (OrderResult order:orderResults) {

            order.traindateresult = order.formatter.format(order.traindate);
            order.orderdateresult=  order.formatter.format(order.orderdate);
        }

        return orderResults;
    }

    @GetMapping("/createOrder")
    public Result createOrder(@RequestParam("accountid") String accountid, @RequestParam("trainnumber") String trainnumber, @RequestParam("traindate") Date traindate, @RequestParam("startlocation") String startlocation, @RequestParam("arrivelocation") String arrivelocation , @RequestParam("name") String name, @RequestParam("passengercard") String passengercard){

        System.out.println("start"+"arrive");
        int startOrder = timeDAO.findStationOrder(trainnumber, startlocation);
        System.out.println("start"+"1111arrive");
        int arriveOrder = timeDAO.findStationOrder(trainnumber, arrivelocation);
        System.out.println("start"+startOrder+"arrive"+arriveOrder);

        //查询途中各站有无余票
        for( int stationOrder = startOrder; stationOrder < arriveOrder; stationOrder++ ){

            int isLeft = timeService.isTicketLeft(trainnumber, traindate, stationOrder);
            if(isLeft <= 0){
                return ResultGenerator.genFailResult("no tickets");
            }
        }

        //Passenger passenger = passengerService.findById(accountid);
        //String name = passenger.getName();
        //String card = passenger.getCardid();

        timeDAO.sell(trainnumber, traindate, startOrder, arriveOrder, 1);

        return ResultGenerator.genSuccessResult(trainorderService.createOrder(accountid, trainnumber, traindate, startOrder, arriveOrder, name, passengercard));
    }

    @GetMapping("/cancelOrder")
    public Result cancelOrder(@RequestParam("orderid") String orderid){

        Trainorder order = trainorderService.findById(orderid);

        String trainnumber = order.getTrainnumber();
        Date traindate = order.getTraindate();
        int startOrder = order.getStartorder();
        int arriveOrder = order.getArriveorder();

        timeDAO.back(trainnumber, traindate, startOrder, arriveOrder, 1);

        return ResultGenerator.genSuccessResult(trainorderService.cancelOrder(orderid));
    }

    @PostMapping("/add")
    public Result add(Trainorder trainorder) {
        trainorderService.save(trainorder);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        trainorderService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Trainorder trainorder) {
        trainorderService.update(trainorder);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Trainorder trainorder = trainorderService.findById(id);
        return ResultGenerator.genSuccessResult(trainorder);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Trainorder> list = trainorderService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
