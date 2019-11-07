package com.blog.lm.sys.handle;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.PatternMatchUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;

/**
 * @Author xus
 * @Date 2019/11/7 14:23
 * @Description TODO
 **/
@Component("pms")
public class PermissionHandle {

    /**
     * 判断是否有xxx:xxx权限
     *
     * @param permission
     * @return
     */
    public boolean hasPermission(String permission) {
        if (StringUtils.isEmpty(permission)) {
            return false;
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (null == authentication) {
            return false;
        }
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        return authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .filter(StringUtils::hasText)
                .anyMatch(r -> PatternMatchUtils.simpleMatch(permission, r));
    }
}
