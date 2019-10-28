package com.zxj.demo.annotation;

import org.springframework.stereotype.Component;

/**
 * Created by upc on 2019/10/3.
 */
@Component("userServiceId")
public class UserServiceImpl implements UserService{
    @Override
    public void addUser() {
        System.out.println("implement UserService");
    }
}
