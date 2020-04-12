package com.example.controller;

import com.example.entity.route;
import com.example.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RouteController {
    @Autowired
    RouteService routeService;
    @PostMapping("/selectRouteByName")
    @ResponseBody
    public List<route> selectRoute(@RequestBody String name){//根据名字查询公交路线
        //List<route> list=routeService.selectRouteByName("%"+name+"%");
        List<route> list=routeService.selectRouteByName(name);//改为精确查询
        if(list.isEmpty()){
            System.out.println("路线查询失败");
        }else{
            System.out.println("路线查询成功");
        }
        return list;
    }
}
