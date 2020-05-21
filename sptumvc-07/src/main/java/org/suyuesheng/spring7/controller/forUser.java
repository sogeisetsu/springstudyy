package org.suyuesheng.spring7.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.suyuesheng.spring7.pojo.ResultInfo;
import org.suyuesheng.spring7.pojo.User;
import org.suyuesheng.spring7.services.UserService;
import org.suyuesheng.spring7.util.GetDomainName;
import org.suyuesheng.spring7.util.GetUUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

@Controller
public class forUser {
    @Autowired
    private UserService userService;

    /**
     * 这样设置初始页面不好使
     * @return
     */
    @GetMapping("/")
    public String index(){
        return "forward:/login.html";
    }

    @GetMapping("/regist")
    public String regist(){
        return "forward:/regist.html";
    }

    @ResponseBody
    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    public Object regist(@RequestBody Map<String,Object> map,ResultInfo resultInfo,HttpServletRequest request){
        System.out.println(map);
        User user = new User();
        user.setUserName((String)map.get("username"));
        user.setPassword((String)map.get("password"));
        user.setEmail((String)map.get("email"));
        user.setStatus("N");
        user.setDate(new Date());
        System.out.println(user);
        userService.insertUser(user,resultInfo,request);
        return JSON.toJSON(resultInfo);
    }

    @RequestMapping("/active")
    public void active(@RequestParam("code") String code, HttpServletResponse response,HttpServletRequest request) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = request.getRequestURL().toString();
        if (code!=null && !code.equals("")){
            if(userService.activeUser(code)){
                String ur = GetDomainName.getDomainName(url) + "login.html";
                System.out.println(ur);
                String msg= "<p>注册成功，请去登录，<a href=\""+ur+"\">登录</a><p>";
                response.getWriter().write(msg);
            }else {
                String msg= "<p>登陆失败，请联系管理员</p>";
                response.getWriter().write(msg);
            }
        }else{
            String msg="<h2>该验证码不存在，请从新注册</h2>";
            response.getWriter().write(msg);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object login(@RequestBody Map<String,Object> map, ResultInfo resultInfo, HttpServletResponse response, HttpServletRequest request){
        HttpSession session = request.getSession();
        boolean login = userService.login((String) map.get("username"), (String) map.get("password"), resultInfo);
        if(login){
            session.setAttribute("login", "true");
            session.setAttribute("whlogin", userService.findByName((String)map.get("username")));
            Cookie c = new Cookie("JSESSIONID",session.getId());
            c.setMaxAge(60*60*24*4);
            response.addCookie(c);
            return JSON.toJSON(resultInfo);
        }
        return JSON.toJSON(resultInfo);
    }

    @GetMapping("/login")
    public String login(){
        return "forward:/login.html";
    }


    @ResponseBody
    @RequestMapping(value = "/test/session")
    public Object testSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        Object login = session.getAttribute("login");
        System.out.println(request.getRequestURL());
        return (String)login;
    }
}


