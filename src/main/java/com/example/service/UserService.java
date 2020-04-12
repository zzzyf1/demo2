package com.example.service;

import com.example.entity.person;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public List<person> Sel (person user){
        List<person> personList=userMapper.SelByUsername(user);
        return personList;
    }
}
