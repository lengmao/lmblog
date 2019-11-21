package com.blog.lm.security.handle;

import cn.hutool.core.collection.CollUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * @Author xus
 * @Date 2019/11/6 16:08
 * @Description 登录成功处理
 **/
@Component
@Slf4j
public class AuthSuccessHandler implements ApplicationListener<AuthenticationSuccessEvent> {

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        Authentication authentication = (Authentication) event.getSource();
        if (CollUtil.isNotEmpty(authentication.getAuthorities())) {
            handle(authentication);
        }
    }

    public void handle(Authentication authentication) {
        log.info("用户：{} 登录成功", authentication.getName());
        log.info("权限：{}",authentication.getAuthorities());
    }
}
