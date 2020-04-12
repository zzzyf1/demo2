package com.example.mapper;

import com.example.entity.person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<person> SelByUsername(person p);
}
