package com.turing.professional_website.service.admin;

import com.turing.professional_website.entity.Content;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Meng
 * @date 2019/11/16
 */
public interface AdminContentService {

    boolean updateDataById(Integer contentTypeId, String ContentTitle,MultipartFile data);

    Content findContentByContentTypeId(Integer contentTypeId);

}
