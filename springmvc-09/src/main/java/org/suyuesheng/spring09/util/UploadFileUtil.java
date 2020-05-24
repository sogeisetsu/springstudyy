package org.suyuesheng.spring09.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class UploadFileUtil {
    public static boolean uploadFile(MultipartFile file,String path){
        try {
            String filename = file.getOriginalFilename();
            File realFile = new File(path, filename);
            if(!realFile.getParentFile().exists()){
                realFile.getParentFile().mkdirs();
            }
            if(realFile.exists()){
                String newFileName = new Random().nextInt(100) + filename;
                realFile.renameTo(new File(path, newFileName));
            }
            file.transferTo(realFile);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
