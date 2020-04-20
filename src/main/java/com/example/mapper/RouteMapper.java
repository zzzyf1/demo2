package com.example.mapper;

import com.example.entity.route;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RouteMapper {
    List<route>  selectRouteByName(String description);//根据线路名称查询线路途径站点
    List<route>  selectRouteByStationID(int station_id);
    int deleteRoute(int id);
}
