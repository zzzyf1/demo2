package com.example.controller;

import com.example.entity.driver;
import com.example.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.security.sasl.SaslServer;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class DriverController {
    @Autowired
    DriverService driverService;

    @PostMapping("/getAllDriverByCity")
    @ResponseBody
    List<driver> getAllDriver(@RequestBody String city){
        List<driver> list;
        list=driverService.selectAllDriverByCity(city);
        if(list!=null&&list.isEmpty()){
            System.out.println("未查询到任何司机");
        }else{
            System.out.println("司机查询成功");
        }
        return list;
    }
    @PostMapping("/getDrivers")
    @ResponseBody
    List<driver> selectAll(@RequestBody String city){
        List<driver> list=driverService.selectDrivers(city);
        if(list!=null&&!list.isEmpty()){
            System.out.println("司机查询成功");
        }else{
            System.out.println("司机查询失败");
        }
        return list;
    }
    @PostMapping("/upload")
    @ResponseBody
    String getHeaderImg(@RequestParam("file") MultipartFile img, @RequestParam("ID") String id, HttpServletRequest request){
        if(img.isEmpty()){
            return "0";
        }
        //文件在服务器上的存储位置
        String path=System.getProperty("user.dir")+"\\src\\main\\resources\\static\\static\\img\\driver\\";
        File targetFile=new File(path);
        System.out.println("文件保存的地址: "+path);
        //目录不存在时创建目录
        if(!targetFile.exists()&&!targetFile.isDirectory()){
            targetFile.mkdirs();
            System.out.println("创建目录");
        }
        //文件命名
        String filename="driver_"+id+".jpg";
        //在指定位置创建一个文件
        File imgFile=new File(path,filename);
        try {
            //存储头像文件到服务器指定位置
            img.transferTo(imgFile);
            System.out.println("头像已经存储");

            return "1";
        } catch (IOException e) {
            System.out.println("头像上传失败");
            e.printStackTrace();
            return "2";
        }
    }

    @PostMapping("/AddDriver")
    @ResponseBody
    String addDriver(@RequestBody driver Dr){
        try{
            int result=driverService.insertDriver(Dr.getDriver_id(),Dr.getDriver_name(),Dr.getPhone(),Dr.getCity(),Dr.getSex(),Dr.getUrl());
            if(result>0){
                System.out.println("司机信息同步成功");
                return "1";
            }else{
                System.out.println("司机信息同步失败");
                return "0";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "3";
        }
    }
    @PostMapping("/refreshDriver")
    @ResponseBody
    String refresh(@RequestBody driver Dr){
        try {
            int result=driverService.refreshDriver(Dr);
            if(result>0){
                System.out.println(Dr.getDriver_id()+"信息更新成功");
                return "1";
            }else{
                System.out.println(Dr.getDriver_id()+"信息更新失败");
                return "0";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "2";
        }

    }
    @PostMapping("/deleteDriver")
    @ResponseBody
    String delete(@RequestBody String id){
        try{
            int result=driverService.deleteDriver(id);
            if(result>0){
                System.out.println("删除成功");
                return "1";
            }else{
                System.out.println("删除失败");
                return "0";
            }

        }catch (Exception e){
            e.printStackTrace();
            return "2";
        }
    }

}
