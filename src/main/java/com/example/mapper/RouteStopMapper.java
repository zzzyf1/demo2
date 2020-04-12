package com.example.mapper;

import com.example.entity.routeStop;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteStopMapper {
    int addRouteStop(routeStop routestop);//单个添加线路站点
}
