package com.turing.professional_website.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Meng
 * @date 2019/11/16
 */
@Component
public class PdfUtil {

    @Value("${pdfPath}")
    private String pdfPath;
    /**
     * 判断文件是否位pdf文件
     * @param data
     * @return
     */
    public boolean isPdf(MultipartFile data) {
        String suffix = data.getOriginalFilename().substring(data.getOriginalFilename().lastIndexOf("."));
        return suffix.equals(".pdf");
    }

    /**
     * 获取UUID作为文件新名字, 16位长度
     * @return
     */
    public String getUUIDName(){
        return UUID.randomUUID().toString().replace("-", "").substring(0, 16);
    }

    /**
     * 删除文件
     * @param filename 文件名
     */
    public void deletePdf(String filename){
        File filePath=new File(pdfPath,filename);
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
     * 将图片存储到本地
     * @param file 文件
     * @return
     */
    public void uploadPdf(MultipartFile file, File uploadFile) throws IOException {
        //判断文件夹是否存在
        File filePath = new File(pdfPath);
        if(!filePath.exists()){
            filePath.mkdirs();
        }
        //上传文件
        file.transferTo(uploadFile);

    }
}
