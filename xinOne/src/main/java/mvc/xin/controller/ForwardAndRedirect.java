package mvc.xin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/far")
public class ForwardAndRedirect {

    @RequestMapping(value = "f01",method = RequestMethod.GET)
    public String f01(HttpServletRequest request,Model model){
        model.addAttribute("hel", "wwswModel");
        request.setAttribute("msg", "hello 尝试forea");
        return "forward:/far/j01?h1=12";
    }

    @RequestMapping("/j01")
    public String j01(HttpServletRequest request){
        System.out.println("request.getAttribute(\"msg\") = " + request.getAttribute("msg"));
        System.out.println("request.getParameterNames() = " + request.getParameterNames());
        System.out.println("request.getParameterValues(\"h1\") = " + request.getParameter("h1"));
        if(request.getParameterNames().hasMoreElements()){
            System.out.println("request.getParameterNames().nextElement() = " + request.getParameterNames().nextElement());
        }

        return "hello";
    }
    @RequestMapping("/r01")
    public String r01(RedirectAttributes model){
        model.addFlashAttribute("msg", "转发");
        return "redirect:/far/jr01";
    }

    @RequestMapping("jr01")
    public String jr01(HttpServletRequest request, @ModelAttribute(value = "msg") String msg, ModelMap modelMap){
        System.out.println("request.getParameterValues(\"msg\") = " + request.getParameterValues("msg"));
        System.out.println("msg = " + msg);
        System.out.println("modelMap.get(\"msg\") = " + modelMap.get("msg"));
        modelMap.entrySet().forEach(System.out::println);
        return "hello";
    }

}
