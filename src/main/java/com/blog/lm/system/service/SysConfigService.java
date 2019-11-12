package com.blog.lm.system.service;

import com.blog.lm.system.entity.Config;

public interface SysConfigService {
    Config getConfigurationByName(String name);
}
