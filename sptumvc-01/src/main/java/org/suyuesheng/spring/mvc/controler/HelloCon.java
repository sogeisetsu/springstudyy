package org.suyuesheng.spring.mvc.controler;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloCon implements Controller {
    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "hehe");
        modelAndView.setViewName("hello");
//        httpServletRequest.setAttribute("ss", "rr");
//        httpServletResponse.sendRedirect("https://www.cnblogs.com/mikevictor07/p/3436393.html");
        return modelAndView;
    }
}
