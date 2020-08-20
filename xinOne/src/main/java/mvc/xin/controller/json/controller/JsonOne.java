package mvc.xin.controller.json.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mvc.xin.controller.json.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/json")
public class JsonOne {

    @ResponseBody
    @RequestMapping(value = "/one" ,method = RequestMethod.POST)
    public Object one(User user) throws JsonProcessingException {
        System.out.println("new ObjectMapper().writeValueAsString(user) = " + new ObjectMapper().writeValueAsString(user));
        return user;
    }

    @ResponseBody
    @RequestMapping(value = "/date",method = RequestMethod.POST)
    public String sGetDate(@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")Date date){
        System.out.println(date);
        return "ded钉钉";
    }

    @ResponseBody
    @RequestMapping(value = "/dateString",method = RequestMethod.POST)
    public Date sGetDateString(@RequestParam("date") String s) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(s);
        Date parse = dateFormat.parse(s);
        return parse;
    }

    @ResponseBody
    @RequestMapping(value = "getJsonOne",method = RequestMethod.POST)
    public String getJsonOne(@RequestBody String tex){
        System.out.println(tex);
        return "成功";
    }

    @ResponseBody
    @RequestMapping(value = "getJsonTwo",method = RequestMethod.POST)
    public String getJsonTwo(@RequestBody(required = false) User user){
        System.out.println(user);
//        try {
//            System.out.println("new ObjectMapper().writeValueAsString(user) = " + new ObjectMapper().writeValueAsString(user));
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
        System.out.println("JSONObject.toJSONString(user) = " + JSONObject.toJSONString(user));

        return JSON.toJSONString(user);
    }

    @ResponseBody
    @RequestMapping(value = "/json",method = RequestMethod.GET)
    public String getJsonByGetMethod(){
        User hello = new User(12, "你好", new Date());
        return JSONObject.toJSONString(hello);
    }
}
