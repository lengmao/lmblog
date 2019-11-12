package com.blog.lm.busi.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.lm.busi.entity.Configuration;
import com.blog.lm.busi.mapper.BusilConfigurationMapper;
import com.blog.lm.busi.service.BusilConfigurationService;
import org.springframework.stereotype.Service;

@Service
public class BusilConfigurationServiceImpl extends ServiceImpl<BusilConfigurationMapper, Configuration> implements BusilConfigurationService {

    @Override
    public Configuration getConfigurationByName(String name) {
        return  baseMapper.selectOne(Wrappers.<Configuration>query().lambda().eq(Configuration::getName, name).eq(Configuration::getDelFlg,0));
    }
}
