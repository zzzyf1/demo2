package com.example.mapper;

import com.example.entity.driver;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriveMapper {
    //返回各个司机以及他们负责的线路
    List<driver> selectAllDriverByCity(String city);
    //返回所有司机
    List<driver> selectDrivers( String city);

}
