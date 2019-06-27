package com.turing.professional_website.service.teacher;

import com.turing.professional_website.entity.TeachBackground;

/**
 * @author Jack
 * @date 2019-06-27-21:40
 */
public interface TeachBackgroundService {
    /**
     * 添加背景信息
     * @param teachBackground 背景信息实体类
     * @return
     */
    public boolean addTeachBackground(TeachBackground teachBackground);

    /**
     * 删除背景信息
     * @param id 背景信息id号
     * @return
     */
    public boolean delTeachBackground(Integer id);

}
