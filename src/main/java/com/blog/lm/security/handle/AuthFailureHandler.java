package com.blog.lm.security.handle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @Author xus
 * @Date 2019/11/6 16:14
 * @Description 登录失败处理
 **/
@Component
@Slf4j
public class AuthFailureHandler implements ApplicationListener<AbstractAuthenticationFailureEvent> {

    @Override
    public void onApplicationEvent(AbstractAuthenticationFailureEvent event) {
        AuthenticationException authenticationException = event.getException();
        Authentication authentication = (Authentication) event.getSource();

        handle(authenticationException, authentication);
    }

    /**
     * 登录失败处理
     *
     * @param authenticationException
     * @param authentication
     */
    public void handle(AuthenticationException authenticationException, Authentication authentication) {
        log.info("用户：{} 登录失败，异常：{}", authentication.getPrincipal(), authenticationException.getLocalizedMessage());
    }

}
