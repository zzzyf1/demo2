package com.example.service;

import com.example.entity.route;
import com.example.mapper.RouteMapper;
import com.example.mapper.RouteStopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {
    @Autowired
    RouteMapper routeMapper;
    public List<route> selectRouteByName(String description){//根据名字模糊查询公交线路
        //System.out.println(description);
        //List<route> routeList=routeMapper.selectRouteByName(description);
        return routeMapper.selectRouteByName(description);
        //return routeList;
    }
    //得到包含该站点的线路节点
    public List<route> selectRouteByStationID(int station_id){return routeMapper.selectRouteByStationID(station_id);}
    public int deleteRoute(int id){return routeMapper.deleteRoute(id);}

}
