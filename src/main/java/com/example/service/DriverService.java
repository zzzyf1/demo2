package com.example.service;

import com.example.entity.driver;
import com.example.mapper.DriveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    @Autowired
    DriveMapper driveMapper;
    public List<driver> selectAllDriverByCity(String city){return driveMapper.selectAllDriverByCity(city);}
    public List<driver> selectDrivers(String city){return driveMapper.selectDrivers(city);}
}
