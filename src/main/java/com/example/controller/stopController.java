package com.example.controller;

import com.example.entity.bus_stop;
import com.example.service.StopService;
import com.example.util.QRutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@Controller
public class stopController {
    @Autowired
    StopService stopService;

    @PostMapping("/queryStop")
    @ResponseBody
    public List<bus_stop> query(@RequestBody String description){
        List<bus_stop> list;
        list=stopService.Sel("%"+description+"%");//模糊搜索，所以要前后加上%
        if(list.isEmpty()){
            System.out.println("站点查询失败");
        }else{
            System.out.println("站点查询成功");
        }
        return list;
    }
    @PostMapping("/queryAllStop")
    @ResponseBody
    public List<bus_stop> queryAll(@RequestBody String description){//参数暂时为空值，后续可能改为根据城市查询
        List<bus_stop> list;
        list=stopService.SelAll(description);
        if(list.isEmpty()){
            System.out.println("站点查询失败");
        }else{
            System.out.println("站点查询成功");
        }
        return list;
    }
    @PostMapping("/AddStop")
    @ResponseBody
    public int addStop(@RequestBody bus_stop busStop){
        int result=stopService.Add(busStop.getStop_name(),busStop.getLatitude(),busStop.getLongitude());
        if(result>0){
            bus_stop stop;
            stop=stopService.SelExactly(busStop);//查询生成的bus_stop的ID,用以生成对应放入二维码
            try{
                //String filePath="E:/myVueDemo/src/assets/";
                String filePath="src/main/resources/static/static/img/";
                filePath=filePath+"stop_"+Integer.toString(stop.getStation_id())+".jpg";
                QRutil.encode(Integer.toString(stop.getStation_id()),filePath);
                //将对应的二维码地址存储到数据库中
                stop.setQr_code_url(filePath);
                //更新数据库
                stopService.UpdateQRLocation(stop);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("成功增加站点");
        }else{
            System.out.println("增加站点失败");
        }
        return result;
    }
    @PostMapping("/DelStop")
    @ResponseBody
    public int deleteStop(@RequestBody int stationId){
        int result = stopService.Del(stationId);
        if(result>0){
            System.out.println("成功删除站点");
        }else{
            System.out.println("删除站点失败");
        }
        return result;
}
    @PostMapping("/UpdStop")
    @ResponseBody
    public int updateStop(@RequestBody bus_stop busStop){
        int result=stopService.Upd(busStop.getStation_id(),busStop.getStop_name(),busStop.getLatitude(),busStop.getLongitude());
        if(result>0){
            System.out.println("成功更新站点");
        }else{
            System.out.println("更新站点失败");
        }
        return result;
    }
    @PostMapping("/showQR")
    @ResponseBody
    public BufferedImage showQR(@RequestBody int stationId){
        BufferedImage image= null;
        try {
            image = ImageIO.read(new File("src/main/resources/static/static/img/" + "stop_" + Integer.toString(stationId) + ".jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
