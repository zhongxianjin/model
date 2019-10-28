package com.zxj.demo.dao;
import com.zxj.demo.entity.Book;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Created by upc on 2019/7/17.
 */
public interface BookDao {
    List<Book> bookDao();
}
