package mvc.xin.controller.json.controller;

import com.alibaba.fastjson.JSONObject;
import mvc.xin.controller.json.pojo.ResultInfo;
import mvc.xin.controller.json.utils.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
@RequestMapping("/file")
public class FileCon {
    @Autowired
    private ResultInfo resultInfo;
    @ResponseBody
    @RequestMapping("/one")
    public Object uploadOne(MultipartHttpServletRequest request){
        MultipartFile multipartFile = request.getFile("file");
        String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/file");
        System.out.println(realPath);
        boolean b = UploadFile.creatTheUploadFie(multipartFile, realPath);
        resultInfo.setaBoolean(b);
        if(b==false){
            resultInfo.setErrorMsg("抱歉，文件上传失败，失败原因未知，请重新上传");
        }
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(resultInfo);
        return jsonObject;
    }

    @GetMapping("Down")
    public void Down(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long start = System.currentTimeMillis();
        String path = request.getSession().getServletContext().getRealPath("/file");
        String fileName="日语1.pdf";
        File file = new File(path, fileName);
        response.reset();
        //3.Content-Disposition常用取值有：attachment和inline，

        //attachment：打开下载框

        //inline：将文件直接显示在页面
        response.setHeader("Content-Disposition","attachment;fileName="+ URLEncoder.encode(fileName, "UTF-8"));

        FileInputStream fileInputStream = new FileInputStream(file);
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] bytes = new byte[1024 * 1024];
        int temp=0;
        while ((temp=fileInputStream.read(bytes))!=-1){
            outputStream.write(bytes, 0, temp);
        }
        outputStream.close();
        fileInputStream.close();
        long end = System.currentTimeMillis();
        System.out.printf("\n花费时间：%d 毫秒",(end-start));
    }
}
