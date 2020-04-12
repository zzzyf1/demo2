package com.example.controller;

import com.example.entity.routeDescription;
import com.example.entity.routeStop;
import com.example.service.RouteDescriptionService;
import com.example.service.RouteStopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.ListIterator;

@Controller
public class RouteStopController {
    @Autowired
    RouteStopService routeStopService;
    @Autowired
    RouteDescriptionService routeDescriptionService;

    @PostMapping("/addRoute")
    @ResponseBody
    public int addRoute(@RequestBody List<routeStop> routeStopListist){
        //先查数据库是否有同名线路,若没有则正常添加线路
        routeDescription check=routeDescriptionService.SelectByRouteDes(routeStopListist.get(0).getDescription());
        if(!routeStopListist.isEmpty()&&check==null){
            //先同步线路，在同步线路站点
            if(routeDescriptionService.Add(routeStopListist.get(0).getDescription())>0){
                int RouteId=routeDescriptionService.SelectByRouteDes(routeStopListist.get(0).getDescription()).getRoute_id();
                ListIterator<routeStop> iterator=routeStopListist.listIterator();
                boolean symbol=true;//线路站点全部添加成功的标志
                while(iterator.hasNext()&&symbol){
                    routeStop stop=iterator.next();
                    stop.setRoute_id(RouteId);
                    if(routeStopService.addRoute(stop)<=0){
                        symbol=false;
                    }
                }
                if(symbol){
                    System.out.println("线路添加成功");
                    return 0;//添加成功
                }else{
                    System.out.println("errorCode=1 -->线路添加失败");
                    return 1;
                }
            }else{
                System.out.println("errorCode=2 -->线路添加失败");
                return 2;
            }
        }else{
            System.out.println("errorCode=3 -->线路添加失败");
            return 3;
        }
    }
}
