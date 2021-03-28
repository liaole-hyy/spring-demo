package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    ServiceMapper serviceMapper ;

    @Override
    public String query() {
        System.out.println("开始测试--------------");
        String name =serviceMapper.query();
        System.out.println("结束测试--------------");
        return name;
    }

    public ServiceMapper getServiceMapper() {
        return serviceMapper;
    }

    public void setServiceMapper(ServiceMapper serviceMapper) {
        this.serviceMapper = serviceMapper;
    }
}
