package com.blog.lm.security.endpoint;


import cn.hutool.core.util.StrUtil;
import com.blog.lm.common.result.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xus
 * @Date 2019/11/7 17:39
 * @Description TODO
 **/
@RestController
@RequestMapping("/token")
public class AuthTokenEndpoint {

    public static final String TOKEN_HEADER = "Authorization";

    public static final String TOKEN_PREFIX = "bearer ";

    @Autowired
    TokenStore tokenStore;

    /**
     * 退出登录，删除token
     * @param authHeader
     * @return
     */
    @DeleteMapping("/logout")
    public JsonResult logout(@RequestHeader(value = HttpHeaders.AUTHORIZATION, required = false) String authHeader) {
        if (StrUtil.isBlank(authHeader)) {
            return new JsonResult("退出失败，token为空");
        }
        String tokenValue = authHeader.replace(TOKEN_PREFIX, StrUtil.EMPTY.trim());
        OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
        if (null == accessToken || StrUtil.isBlank(accessToken.getValue())) {
            return new JsonResult("退出失败，token无效");
        }
        tokenStore.removeAccessToken(accessToken);
        OAuth2RefreshToken refreshToken = accessToken.getRefreshToken();
        tokenStore.removeRefreshToken(refreshToken);
        return new JsonResult("退出成功！");
    }
}
