package com.example.mapper;

import com.example.entity.bus_stop;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StopMapper {
    List<bus_stop> Sel(String stop_name);//根据站点名字进行模糊查询
    List<bus_stop> SelAll(String stop_name);//查询所有站点，参数暂时为空值，后续可能改为根据城市查询
    bus_stop SelExactly(bus_stop busStop);//根据名字，纬度和经度 精确查询站点
    int Del(int station_id);//根据站点ID删除
    int Add(@Param("stop_name")String stop_name, @Param("latitude")double latitude, @Param("longitude")double longitude ,@Param("street") String street);//添加站点信息
    int Upd(@Param("station_id")int station_id ,@Param("stop_name")String stop_name,@Param("latitude")double latitude,@Param("longitude")double longitude ,@Param("street") String street);//根据站点id来更新站点信息
    int UpdateQRLocation(bus_stop busStop);//更新站点对应二维码的存储地址
}
