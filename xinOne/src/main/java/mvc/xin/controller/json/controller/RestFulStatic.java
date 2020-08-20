package mvc.xin.controller.json.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestFulStatic {
    @GetMapping("/uploadFile")
    public String uploadFile(){
        return "forward:/uploadFile.html";
    }
}
