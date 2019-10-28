package com.zxj.demo.annotation;

import org.springframework.stereotype.Repository;

/**
 * Created by upc on 2019/10/4.
 */
@Repository("studentDaoId")
public class StudentDaoImpl implements StudentDao{
    @Override
    public void save() {
        System.out.println("save");
    }
}
