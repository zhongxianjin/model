package com.zxj.demo.service;

/**
 * Created by upc on 2019/7/17.
 */
import com.zxj.demo.dao.BookDao;
import com.zxj.demo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceTemp implements BookService {

    //    使用 dao 中的接口
    @Autowired
    private BookDao bookDao;
    @Override
    public List<Book> listAll() {
        return bookDao.bookDao();
    }
}
