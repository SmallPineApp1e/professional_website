package com.turing.professional_website.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Jack
 * @date 2019-03-23-21:58
 */
public class ImageUtil {
    /**
     * 判断文件是否为图片
     * @param file
     * @return
     */
    public static boolean isPhoto(MultipartFile file){

        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        return ".jpg".equalsIgnoreCase(suffix) || ".jpeg".equalsIgnoreCase(suffix) ||
                ".png".equalsIgnoreCase(suffix) || ".gif".equalsIgnoreCase(suffix)
                || ".bmp".equalsIgnoreCase(suffix);

    }

    /**
     * 将图片存储到本地
     * @param pathName 路径名
     * @param file 文件
     * @return
     */
    public static void uploadPhoto(String pathName, MultipartFile file, File uploadFile) throws IOException {

        File filePath = new File(pathName);
        if(!filePath.exists()){
            filePath.mkdirs();
        }
        file.transferTo(uploadFile);

    }

    /**
     * 获得图片的后缀名 包括"." 例如.jpg
     * @param file
     * @return
     */
    public static String getSuffix(MultipartFile file){

        return file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

    }

}
