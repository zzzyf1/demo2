package com.example.mapper;

import com.example.entity.routeDescription;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteDescriptionMapper {
    int AddRouteDescription( String description);
    routeDescription selectRouteByDes(String description);
}
