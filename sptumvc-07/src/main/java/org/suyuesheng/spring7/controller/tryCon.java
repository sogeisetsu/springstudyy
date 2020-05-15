package org.suyuesheng.spring7.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.suyuesheng.spring7.pojo.User;
import org.suyuesheng.spring7.services.UserService;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/try")
public class tryCon {

    @RequestMapping("/h1")
    public String h1() {
        System.out.println("访问h1");
        return "redirect:/index.html";
    }

    @RequestMapping("/getjson")
    @ResponseBody
    public Object getjson() {
        User user = new User(12, "老看看ssd898", "2145264");
        System.out.println(JSON.toJSONString(user));
        user.setDate(new Date());
        return JSON.toJSON(user);
    }

    @RequestMapping("/sql")
    @ResponseBody
    public Object showSql() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        UserService userservice = context.getBean("userservice", UserService.class);
        List<User> all = userservice.findAll();
        System.out.println(JSON.toJSON(all));
        return JSON.toJSON(all);
    }
    //restFul风格
    @RequestMapping("/sql/{id}")
    @ResponseBody
    public Object showSqlById(@PathVariable int id){
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        UserService userservice = context.getBean("userservice", UserService.class);
        return JSON.toJSON(userservice.findById(id));
    }
}
