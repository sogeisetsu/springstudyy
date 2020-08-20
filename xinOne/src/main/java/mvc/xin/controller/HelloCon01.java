package mvc.xin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/h01")
public class HelloCon01 {
    @RequestMapping("/one")
    public String OneCon(Model model, HttpServletRequest request){
//        msg内容发生冲突时（model和request都设置了msg），使用model的内容
//        有多个msg（比如request设置了多个msg），以最后一个msg为准
        request.setAttribute("msg", "zhuanf");
//        request.setAttribute("msg", "0102");
//        model.addAttribute("msg", "helloOne");
        System.out.println("model.getAttribute(\"msg\") = " + model.getAttribute("msg"));
        return "hello";
    }

    @RequestMapping("/Rest/{a}/{b}")
    public String rest(@PathVariable int a,@PathVariable int b,Model model){
        model.addAttribute("msg", a+b);
        System.out.println("model.getAttribute(\"msg\") = " + model.getAttribute("msg"));
        return "hello";
    }
}
