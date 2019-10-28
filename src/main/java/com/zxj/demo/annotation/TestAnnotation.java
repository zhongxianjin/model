package com.zxj.demo.annotation;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by upc on 2019/10/3.
 */
public class TestAnnotation {
    @Test
    public void demo(){
        UserService userService=new UserServiceImpl();
        userService.addUser();
    }
    @Test
    public void demo1(){
        String xmlPath= "spring_root.xml";
        ApplicationContext context=new ClassPathXmlApplicationContext(xmlPath);
        UserService userService= (UserService) context.getBean("userServiceId");
        userService.addUser();
    }
    @Test
    public void demo2(){
        String xmlPath= "spring_root.xml";
        ApplicationContext context=new ClassPathXmlApplicationContext(xmlPath);
        StudentAction studentAction= (StudentAction) context.getBean("studentActionId");
        studentAction.exectue();
    }
    @Test
    public void demo3(){
        String xmlPath= "spring_root.xml";
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext(xmlPath);
        ScopeUserService scopeUserService1= context.getBean("scopeStudentActionId",ScopeUserService.class);
        ScopeUserService scopeUserService2= context.getBean("scopeStudentActionId",ScopeUserService.class);
        System.out.println(scopeUserService1);
        System.out.println(scopeUserService2);
        context.close();
    }
}
