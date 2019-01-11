package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.dao.TimeDAO;
import com.company.project.model.Passenger;
import com.company.project.model.Trainorder;
import com.company.project.service.PassengerService;
import com.company.project.service.TimeService;
import com.company.project.service.TrainorderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jdk.vm.ci.meta.Local;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
* Created by CodeGenerator on 2018/12/03.
*/
@RestController
@RequestMapping("/trainorder")
public class TrainorderController {
    @Resource
    private TrainorderService trainorderService;
    private PassengerService passengerService;
    private TimeService timeService;
    private TimeDAO timeDAO;

    @GetMapping("/findHistoryOrder")
    public List<Trainorder> findHistoryOrder(@RequestParam("accountid") String accountid, @RequestParam("start") Date start, @RequestParam("end") Date end) {

        return trainorderService.findHistoryOrder(accountid, start, end);
    }

    @GetMapping("/createOrder")
    public boolean createOrder(@RequestParam("accountid") String accountid, @RequestParam("trainnumber") String trainnumber, @RequestParam("traindate") LocalDate traindate, @RequestParam("startlocation") String startlocation, @RequestParam("arrivelocation") String arrivelocation){

        int startOrder = timeDAO.findStationOrder(trainnumber, traindate, startlocation);
        int arriveOrder = timeDAO.findStationOrder(trainnumber, traindate, arrivelocation);

        //查询途中各站有无余票
        for( int stationOrder = startOrder; stationOrder < arriveOrder; stationOrder++ ){

            boolean isLeft = timeService.isTicketLeft(trainnumber, traindate, stationOrder);
            if(isLeft != true){
                return false;
            }
        }

        Passenger passenger = passengerService.findById(accountid);
        String name = passenger.getName();
        String card = passenger.getCardid();

        timeDAO.sell(trainnumber, traindate, startOrder, arriveOrder, 1);

        return trainorderService.createOrder(accountid, trainnumber, traindate, startOrder, arriveOrder, name, card);
    }

    @GetMapping("/cancelOrder")
    public boolean cancelOrder(@RequestParam("orderid") String orderid){

        Trainorder order = trainorderService.findById(orderid);

        String trainnumber = order.getTrainnumber();
        LocalDate traindate = order.getTraindate();
        int startOrder = order.getStartorder();
        int arriveOrder = order.getArriveorder();

        timeDAO.back(trainnumber, traindate, startOrder, arriveOrder, 1);

        return trainorderService.cancelOrder(orderid);
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
