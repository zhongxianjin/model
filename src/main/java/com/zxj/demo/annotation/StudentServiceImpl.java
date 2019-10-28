package com.zxj.demo.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by upc on 2019/10/4.
 */
@Service
public class StudentServiceImpl implements StudentService{
    private StudentDao studentDao;

    @Autowired
    @Qualifier("studentDaoId")
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void addStudent() {
        studentDao.save();
        System.out.println("add Student");
    }
}
