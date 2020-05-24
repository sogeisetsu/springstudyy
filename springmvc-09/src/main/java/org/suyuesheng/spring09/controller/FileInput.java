package org.suyuesheng.spring09.controller;


import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.suyuesheng.spring09.pojo.User;
import org.suyuesheng.spring09.util.UploadFileUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class FileInput {

    @RequestMapping("/h1")
    public String one(){
        return "nihao,你好";
    }

    @RequestMapping(value = "/h2",method = RequestMethod.POST)
    public Object two(HttpServletRequest request, @RequestParam("email") String email){
        MultipartHttpServletRequest request1 = (MultipartHttpServletRequest) request;
        String username = request1.getParameter("username");
        System.out.println(request1.getParameter("password"));
//        System.out.println(request1.getParameter("username"));
        MultipartFile file = request1.getFile("file");
        String path = request1.getSession().getServletContext().getRealPath("/WEB-INF/file");
        System.out.println(path);
        String filename = file.getOriginalFilename();
        File file1 = new File(path, filename);
        if(!file1.getParentFile().exists()){
            file1.getParentFile().mkdirs();
        }
        if(file1.exists()){
            file1.delete();
        }
        try {
            file.transferTo(file1);
            System.out.println("成功创建文件"+file1.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(username);
        User user = new User();
        user.setName("hahah");
        user.setName(username);
        user.setPassword(request1.getParameter("password"));
        System.out.println(email);
        return user;
    }

    @RequestMapping(value = "/h3",method = RequestMethod.POST)
    public Object three(MultipartHttpServletRequest request){
        MultipartFile file = request.getFile("file");
        String contentType = file.getContentType();
        System.out.println("文件类型"+contentType);
        String filename = file.getOriginalFilename();
        String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/file");
        boolean b = UploadFileUtil.uploadFile(file, realPath);
        if(b){
            System.out.println("创建文件成功"+"\t"+filename);
        }else {
            System.out.println("文件创建失败");
        }
        return JSON.toJSON(new User("老刘", "12354657"));
    }
}
