package com.example.controller;

import com.example.entity.driverRoute;
import com.example.entity.routeDescription;
import com.example.service.DriverRouteService;
import com.example.service.RouteDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.ListIterator;

@Controller
public class DriverRouteController {
    @Autowired
    DriverRouteService driverRouteService;
    @Autowired
    RouteDescriptionService routeDescriptionService;
    @PostMapping("/addDriverRoute")
    @ResponseBody
    public int add(@RequestBody List<driverRoute> list){
        int RouteId;
        routeDescription routeDes;
        routeDes=routeDescriptionService.SelectByRouteDes(list.get(0).getDescription());
        if(routeDes!=null){
            RouteId=routeDes.getRoute_id();
            ListIterator<driverRoute> iterator=list.listIterator();
            boolean symbol=false;
            while(iterator.hasNext()){
                driverRoute dr;
                dr=iterator.next();
                dr.setRoute_id(RouteId);
                if(driverRouteService.insert(dr)>0){
                    symbol=true;
                }else{
                    symbol=false;
                }
            }
            if(symbol){
                System.out.println("添加司机-线路成功");
                return 1;
            }else{
                System.out.println("添加司机-线路失败");
                return 0;
            }
        }else{
            return -1;
        }
    }

}
