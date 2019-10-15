package com.turing.professional_website.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Jack
 * @date 2019-03-23-21:58
 */
@Component
public class ImageUtil {

    @Value("${teacher.ImgPath}")
    private String imgPath;
    private String defaultImgPath="/static/icon/1.png";

    /**
     * 判断文件是否为图片
     * @param file
     * @return
     */
    public boolean isPhoto(MultipartFile file){

        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        return ".jpg".equalsIgnoreCase(suffix) || ".jpeg".equalsIgnoreCase(suffix) ||
                ".png".equalsIgnoreCase(suffix) || ".gif".equalsIgnoreCase(suffix)
                || ".bmp".equalsIgnoreCase(suffix);

    }

    /**
     * 将图片存储到本地
     * @param file 文件
     * @return
     */
    public void uploadPhoto(MultipartFile file, File uploadFile) throws IOException {
        //判断文件夹是否存在
        File filePath = new File(imgPath);
        if(!filePath.exists()){
            filePath.mkdirs();
        }
        //上传文件
        file.transferTo(uploadFile);

    }

    /**
     * 删除文件
     * @param filename 文件名
     */
    public void deletePhoto(String filename){
        if(filename.equals(defaultImgPath)) return;
        File filePath=new File(imgPath,filename);
        filePath.delete();
    }

    /**
     * 获取文件名
     * @param path 数据库中的相对路径
     * @return 带后缀的文件名
     */
    public String getFileName(String path){
        return path.substring(path.lastIndexOf("/")+1);
    }

    /**
     * 获得图片的后缀名 包括"." 例如.jpg
     * @param file
     * @return
     */
    public String getSuffix(MultipartFile file){

        return file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

    }

    /**
     * 获取UUID作为文件新名字, 16位长度
     * @return
     */
    public String getUUIDName(){
        return UUID.randomUUID().toString().replace("-", "").substring(0, 16);
    }

}
