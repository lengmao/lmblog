package com.blog.lm.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.lm.system.entity.Config;
import com.blog.lm.system.mapper.SysConfigMapper;
import com.blog.lm.system.service.SysConfigService;
import org.springframework.stereotype.Service;

@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, Config> implements SysConfigService {

    @Override
    public Config getConfigurationByName(String name) {
        return baseMapper.selectOne(Wrappers.<Config>query().lambda().eq(Config::getName, name).eq(Config::getDelFlg, 0));
    }
}
