package com.example.service;

import com.example.entity.routeDescription;
import com.example.mapper.RouteDescriptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteDescriptionService {
    @Autowired
    RouteDescriptionMapper routeDescriptionMapper;
    public int Add(String description){
        return routeDescriptionMapper.AddRouteDescription(description);
    }
    public routeDescription SelectByRouteDes(String description){
        return routeDescriptionMapper.selectRouteByDes(description);
    }


}
