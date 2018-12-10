package com.company.project.web;


import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService AdminServiceImpl;

    /*
    获取某段时间的新增订单数
     */
    @GetMapping(value = "addCount")
    public Result getAddCountPerDay(@RequestParam LocalDate start,
                                    @RequestParam LocalDate end,
                                    @RequestParam int status){
        return ResultGenerator.genSuccessResult(AdminServiceImpl.findbyTime(start,end,status));
    }



}
