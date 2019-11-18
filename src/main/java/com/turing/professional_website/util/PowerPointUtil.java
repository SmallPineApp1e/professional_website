package com.turing.professional_website.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Jack
 * @date 2019-11-16-18:52
 */
@Component
public class PowerPointUtil {

    @Value(value = "${powerPointPath}")
    private String powerPointPath;

    /**
     * 获取UUID作为文件新名字, 16位长度
     * @return
     */
    public String getUUIDName(){
        return UUID.randomUUID().toString().replace("-", "").substring(0, 16);
    }

    public boolean isPowerPoint(MultipartFile file){
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        return suffix.toLowerCase().equals(".ppt");
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
     * 将图片存储到本地
     * @param file 文件
     * @return
     */
    public void uploadPowerPoint(MultipartFile file, File uploadFile) throws IOException {
        //判断文件夹是否存在
        File filePath = new File(powerPointPath);
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
        File filePath=new File(powerPointPath,filename);
        filePath.delete();
    }

}
