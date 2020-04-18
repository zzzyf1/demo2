package com.example.mapper;

import com.example.entity.driver;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriveMapper {
    //返回各个司机以及他们负责的线路
    List<driver> selectAllDriverByCity(String city);
    //返回所有司机
    List<driver> selectDrivers( String city);
    //添加司机
    int insertDriver(@Param("driver_id") String driver_id,@Param("driver_name") String driver_name,@Param("phone") String phone,@Param("city") String city,@Param("sex") String sex,@Param("url") String url);
    int refresh(driver Dr);
    int deleteDriver(String id);

}
