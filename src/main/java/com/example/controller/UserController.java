package com.example.controller;

import com.example.entity.Book;
import com.example.entity.person;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/user")
    @ResponseBody
    public List<person> test2(@RequestBody person p){
        List<person> personList;
        personList=userService.Sel(p);
        if(personList!=null&&personList.isEmpty()){
            System.out.println("登陆失败");
        }else{
            System.out.println("登陆成功");
        }
        return personList;
    }
}

