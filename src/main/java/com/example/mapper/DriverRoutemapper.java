package com.example.mapper;

import com.example.entity.driverRoute;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRoutemapper {
    int insert(driverRoute dr);
}
