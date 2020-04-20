package com.example.service;

import com.example.entity.bus_stop;
import com.example.mapper.StopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StopService {
    @Autowired
    StopMapper stopMapper;
    public List<bus_stop> Sel(String description){
        return stopMapper.Sel(description);
    }
    public List<bus_stop> SelAll(String description){
        return stopMapper.SelAll(description);
    }
    public bus_stop SelExactly(bus_stop busStop){return stopMapper.SelExactly(busStop);}
    public int Del(int station_id){ return stopMapper.Del(station_id);}
    public int Upd(int station_id ,String stop_name,double latitude,double longitude,String street){return stopMapper.Upd(station_id,stop_name,latitude,longitude,street);}
    public int Add(String stop_name,double latitude,double longitude,String street){
        return stopMapper.Add(stop_name,latitude,longitude,street);}
    public int UpdateQRLocation(bus_stop busStop){return stopMapper.UpdateQRLocation(busStop);}
}
