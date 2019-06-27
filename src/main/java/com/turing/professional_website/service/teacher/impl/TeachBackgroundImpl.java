package com.turing.professional_website.service.teacher.impl;

import com.turing.professional_website.dao.TeachBackgroundMapper;
import com.turing.professional_website.entity.TeachBackground;
import com.turing.professional_website.entity.TeachBackgroundExample;
import com.turing.professional_website.service.teacher.TeachBackgroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jack
 * @date 2019-06-27-21:40
 */
@Service
public class TeachBackgroundImpl implements TeachBackgroundService {

    @Autowired
    TeachBackgroundMapper teachBackgroundMapper;

    @Override
    public boolean addTeachBackground(TeachBackground teachBackground) {

        int row = teachBackgroundMapper.insert(teachBackground);
        return (row != 0);

    }

    @Override
    public boolean delTeachBackground(Integer id) {

        TeachBackgroundExample teachBackgroundExample = new TeachBackgroundExample();
        teachBackgroundExample.createCriteria().andBackgroundIdEqualTo(id);
        int row = teachBackgroundMapper.deleteByExample(teachBackgroundExample);
        return row != 0;

    }

}
