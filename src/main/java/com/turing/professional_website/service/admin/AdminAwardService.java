package com.turing.professional_website.service.admin;

import com.turing.professional_website.entity.Award;

/**
 * @author Jack
 * @date 2019-06-27-21:51
 *
 */
public interface AdminAwardService {
    /**
     * 添加获奖信息
     * @param award 获奖信息实体类
     * @return
     */
    public boolean addAward(Award award);

    /**
     * 根据id删除获奖信息
     * @param awardId 获奖信息的id号
     * @return
     */
    public boolean delAward(Integer awardId);

}
