package com.blog.lm.sys.config;

import com.blog.lm.sys.handle.*;
import com.blog.lm.sys.security.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author xus
 * @Date 2019/11/6 13:54
 * @Description TODO
 **/
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthEntryPointHandle authEntryPointHandle;
    @Autowired
    AuthSuccessHandler authSuccessHandler;
    @Autowired
    AuthFailureHandler authFailureHandler;
    @Autowired
    SessionExpiredStrategy sessionExpiredStrategy;
    @Autowired
    LogoutHandler logoutHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //接口权限配置
        http.authorizeRequests()
                .antMatchers("/register", "/login","/user").permitAll() //不需要权限校验
                .anyRequest().authenticated() //剩余全部需要权限校验
                //登录成功失败
                .and().formLogin().loginPage("/login").loginProcessingUrl("/postLogin").permitAll().successHandler(authSuccessHandler).failureHandler(authFailureHandler)
                //未登录处理
                .and().exceptionHandling().authenticationEntryPoint(authEntryPointHandle)
                //登出
                .and().logout().permitAll().logoutSuccessHandler(logoutHandler).deleteCookies("JSESSIONID")
                //设置账号只能在一处登录--账号异地登录
                .and().sessionManagement().maximumSessions(1).expiredSessionStrategy(sessionExpiredStrategy);
        http.csrf().disable();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailServiceImpl();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
