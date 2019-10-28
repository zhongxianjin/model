package com.zxj.demo.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by upc on 2019/10/4.
 */
@Service("scopeStudentActionId")
//@Scope("prototype")//多例
public class ScopeUserServiceImpl implements ScopeUserService{
    @Override
    public void addUser() {
        System.out.println("Scope Add User");
    }
    @PostConstruct
    void init(){
        System.out.println("init");
    }
    @PreDestroy
    void destory(){
        System.out.println("destroy");
    }
}
