package com.blog.lm.security.handle;

import cn.hutool.core.util.StrUtil;
import com.blog.lm.common.constant.CommonConstant;
import com.blog.lm.common.exception.CheckedException;
import com.blog.lm.common.exception.ValidateCodeException;
import com.blog.lm.security.endpoint.AuthTokenEndpoint;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Author xus
 * @Date 2019/11/7 17:51
 * @Description TODO
 **/
@Component
public class AuthRequestFilter extends OncePerRequestFilter {
    private final String DEFAULT_CODE_PATH = "/api";
    @Autowired
    TokenStore tokenStore;
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(AuthTokenEndpoint.TOKEN_HEADER);
        if (header == null || !header.startsWith(AuthTokenEndpoint.TOKEN_PREFIX)) {
            String url = request.getRequestURI();
            if (url.startsWith(DEFAULT_CODE_PATH)) {
                chain.doFilter(request, response);
                return;
            } else {
                try {
                    validate(request.getParameter("codeStr"));
                    chain.doFilter(request, response);
                    return;
                } catch (Exception e) {
                    throw new CheckedException(e.getMessage());
                }
            }
        }
        SecurityContextHolder.getContext().setAuthentication(getAuthentication(header));
        chain.doFilter(request, response);
    }

    /**
     * 使用token获取用户信息
     *
     * @param tokenHeader
     * @return
     */
    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader) {
        String accessToken = tokenHeader.replace(AuthTokenEndpoint.TOKEN_PREFIX, "");
        OAuth2AccessToken token = tokenStore.readAccessToken(accessToken);
        OAuth2Authentication oAuth2Auth = tokenStore.readAuthentication(token);
        Authentication authentication = oAuth2Auth.getUserAuthentication();
        String username = authentication.getName();
        if (null != username) {
            return new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
        }
        return null;
    }

    /**
     * 登录过程校验验证码
     *
     * @param imageCode
     */
    public void validate(String imageCode) throws Exception {

        if (StrUtil.isBlank(imageCode)) {
            throw new ValidateCodeException("验证码不能为空");
        }
        String key = CommonConstant.DEFAULT_CODE_KEY + imageCode;
        if (!redisTemplate.hasKey(key)) {
            throw new ValidateCodeException("验证码不合法");
        }
        Object codeObj = redisTemplate.opsForValue().get(key);

        if (codeObj == null) {
            throw new ValidateCodeException("验证码不合法");
        }

        String saveCode = codeObj.toString();
        if (StrUtil.isBlank(saveCode)) {
            redisTemplate.delete(key);
            throw new ValidateCodeException("验证码不合法");
        }

        if (!StrUtil.equals(saveCode, imageCode)) {
            redisTemplate.delete(key);
            throw new ValidateCodeException("验证码不合法");
        }

        redisTemplate.delete(key);
    }
}
