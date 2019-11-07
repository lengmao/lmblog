package com.blog.lm.sys.handle;

import com.alibaba.fastjson.JSON;
import com.blog.lm.busi.entity.SysUser;
import com.blog.lm.common.result.JsonResult;
import com.blog.lm.common.result.ResultCode;
import com.blog.lm.common.result.ResultTool;
import com.blog.lm.sys.security.MyUser;
import com.blog.lm.util.JwtTokenUtils;
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
public class AuthSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //TODO 返回该用户拥有的菜单等等
        MyUser user = (MyUser) authentication.getPrincipal();
        Map<String, Object> res = new HashMap<>();
        res.put("access_token", JwtTokenUtils.generatorToken(user.getUsername(), false));
        res.put("token_type", "bearer");
        res.put("username", user.getUsername());

        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(res));
    }
}
