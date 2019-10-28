package com.zxj.demo.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by upc on 2019/10/4.
 */
@Controller("studentActionId")
public class StudentAction {

    @Autowired
    private StudentService studentService;

    public void exectue() {
        studentService.addStudent();
        System.out.println("action");
    }
}
