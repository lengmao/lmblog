package com.blog.lm.security.handle;

import com.alibaba.fastjson.JSON;
import com.blog.lm.security.security.MyUser;
import com.blog.lm.util.JwtTokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author xus
 * @Date 2019/11/6 16:08
 * @Description 登录成功处理
 **/
@Component
@Slf4j
public class AuthSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //TODO 返回该用户拥有的菜单等等
        MyUser user = (MyUser) authentication.getPrincipal();
        log.info("用户名：{}",user.getUsername());
        log.info("用户权限：{}",user.getAuthorities());
        Map<String, Object> res = new HashMap<>();
        res.put("Access_Token", JwtTokenUtils.generatorToken(user.getUsername(), false));
        res.put("Token_Type", "Bearer");
        res.put("UserName", user.getUsername());
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(res));
    }
}
