package com.example.service;

import com.example.entity.driverRoute;
import com.example.mapper.DriverRoutemapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverRouteService {
    @Autowired
    DriverRoutemapper driverRoutemapper;
    public int insert(driverRoute dr){return driverRoutemapper.insert(dr);}
}
