package com.example.service;

import com.example.entity.routeStop;
import com.example.mapper.RouteStopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteStopService {
    @Autowired
    RouteStopMapper routeStopMapper;
    public int addRoute(routeStop routestop){
        return routeStopMapper.addRouteStop(routestop);
    }
}
