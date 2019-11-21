package com.blog.lm.security.handle;

import com.blog.lm.security.endpoint.AuthTokenEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    TokenStore tokenStore;
    @Autowired
    AuthFailureHandler failureHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(AuthTokenEndpoint.TOKEN_HEADER);
        if (header == null || !header.startsWith(AuthTokenEndpoint.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }

        SecurityContextHolder.getContext().setAuthentication(getAuthentication(header));
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader) {
        String accessToken = tokenHeader.replace(AuthTokenEndpoint.TOKEN_PREFIX , "");
        OAuth2AccessToken token = tokenStore.readAccessToken(accessToken);
        OAuth2Authentication oAuth2Auth = tokenStore.readAuthentication(token);
        Authentication authentication = oAuth2Auth.getUserAuthentication();
        String username = authentication.getName();
        if (null != username) {
            return new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
        }
        return null;
    }
}
