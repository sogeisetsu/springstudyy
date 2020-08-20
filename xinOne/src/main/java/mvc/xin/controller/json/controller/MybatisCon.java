package mvc.xin.controller.json.controller;

import mvc.xin.controller.json.pojo.User;
import mvc.xin.controller.json.services.UserServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sql")
public class MybatisCon {
    @Autowired
    private UserServicesImpl userServices;
    @ResponseBody
    @PostMapping("/insert")
    public boolean insert(@RequestBody User user){
        System.out.println("user = " + user);
        boolean b=false;
        if(user!=null){
            b=userServices.insertUser(user);
        }
        return b;
    }

}
