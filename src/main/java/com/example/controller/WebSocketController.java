package com.example.controller;

import com.example.entity.Location;
import com.example.entity.Routes;
import com.example.entity.route;
import com.example.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Controller
public class WebSocketController {
    @Autowired
    private RouteService routeService;

    @MessageMapping("/welcome17")//尾号16代表16路公交车实时上传位置的接口，并通过@SendTo注解广播给所有订阅用户
    @SendTo("/topic/getResponse17")//尾号16即订阅16路的实时位置
    public Location test(@RequestBody Location location){
        System.out.println(String.valueOf(location.getLatitude()));
        return location;
    }
    /**
     * 与安卓客户端采用OkHttp框架交互
     * 扫描二维码后，根据ID查询途径该站点的所有线路
     * 返回值：各个线路的站点情况
     * */
    @PostMapping("/getAllRoute")
    @ResponseBody
    public List<Routes> findAllRoutes(@RequestParam("station_id") String station_id){
        List<route> routeList;
        List<Routes> routes = new ArrayList<>();
        System.out.println(station_id);
        routeList=routeService.selectRouteByStationID(Integer.valueOf(station_id));
        //利用查询到的线路节点，反向查询该线路的所有站点
        if(routeList!=null&&!routeList.isEmpty()){
            ListIterator<route> iterator=routeList.listIterator();
            while(iterator.hasNext()){
                Routes mRoutes =new Routes();
                String description=iterator.next().getDescription();
                List<route> route = routeService.selectRouteByName(description);
                mRoutes.setRouteList(route);
                routes.add(mRoutes);
            }
            return routes;
        }else{
            return routes;
        }
    }
    @PostMapping("/testOkHttp")
    @ResponseBody
    public String say(@RequestParam("station_id") String station_id){
        System.out.println(station_id);
        return "接受到ID"+station_id;
    }
}
