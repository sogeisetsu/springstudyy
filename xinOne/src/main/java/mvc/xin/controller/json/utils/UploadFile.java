package mvc.xin.controller.json.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
@Component
public class UploadFile {
    //将MultipartFile转为file
    public static boolean creatTheUploadFie(MultipartFile multipartFile,String path) {
        boolean b = false;
        String multipartFileOriginalFilename = multipartFile.getOriginalFilename();
        File file = new File(path, multipartFileOriginalFilename);
        //检测文件是否存在，若存在，就改名 直到不重名
        while (b=testFileIsExisting(file)){
            b=testFileIsExisting(file);
        }
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            //此时b一定是false，!b为true
            b=!b;
            e.printStackTrace();
        }
        //b 如果文件存在就是true，不存在就是false；
        // 当文件不存在的时候才能将multipartFile转化成文件(防止覆盖别的文件),
        // 故只有文件状态是false的时候转换文件这件事可以是true
        return !b;
    }

    //检测File是否存在
    //如果文件存在就改名
    private static boolean testFileIsExisting(File file) {
        boolean b = false;
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (file.exists()) {
            //保证名称可以最大可能不同
            String fileNewName =  new Random().nextInt(100)+String.valueOf(new Date().getTime()).substring(10) +file.getName();
            try {
                String path = file.getParentFile().getCanonicalPath();
                file.renameTo(new File(path, fileNewName));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        b=file.exists();
        return b;
    }
}
