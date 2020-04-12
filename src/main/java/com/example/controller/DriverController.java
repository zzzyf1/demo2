package com.example.controller;

import com.example.entity.driver;
import com.example.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DriverController {
    @Autowired
    DriverService driverService;

    @PostMapping("/getAllDriverByCity")
    @ResponseBody
    List<driver> getAllDriver(@RequestBody String city){
        List<driver> list;
        list=driverService.selectAllDriverByCity(city);
        if(list!=null&&list.isEmpty()){
            System.out.println("未查询到任何司机");
        }else{
            System.out.println("司机查询成功");
        }
        return list;
    }
    @PostMapping("/getDrivers")
    @ResponseBody
    List<driver> selectAll(@RequestBody String city){
        List<driver> list=driverService.selectDrivers(city);
        if(list!=null&&list.isEmpty()){
            System.out.println("司机查询成功");
        }else{
            System.out.println("司机查询失败");
        }
        return list;
    }
}
