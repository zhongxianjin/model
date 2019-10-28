package com.zxj.demo.web;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

/**
 * Created by upczh on 2019/8/17.
 */
@Controller
public class WebControl {


//    private Logger log;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello world";
    }
    @Test
    public void test(){

    }
    @RequestMapping(value = "/addcomment", produces = "application/json; charset=utf-8")
    public @ResponseBody String addComment(String params) throws IOException {
//        log.info("-----------------开始addcomment------------------------------------");

//        log.info("-----------------结束addcomment------------------------------------");
        return params;

    }
    @RequestMapping(value = "/post/addcomment", produces = "application/json; charset=utf-8")
    public @ResponseBody String addPost(@RequestBody String params) throws IOException {
//        log.info("-----------------开始addcomment------------------------------------");

//        log.info("-----------------结束addcomment------------------------------------");
        return params;

    }
//    @Autowired
//    private BookService bookService;
//
//    //    请求url
//    @RequestMapping(value = "/book")
//    public ModelAndView getList(){
////        页面的名字
//        ModelAndView mv = new ModelAndView("list");
////        获取数据
//        List<Book> list = bookService.listAll();
//        mv.addObject("book",list);
//        return mv;
//    }
}
