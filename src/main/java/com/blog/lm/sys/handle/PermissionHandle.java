package com.blog.lm.sys.handle;

import com.blog.lm.busi.service.SysUserService;
import com.blog.lm.common.dto.UserDto;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
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

    @Autowired
    SysUserService userService;

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

        String userName = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDto userDto = userService.getUserByName(userName);
        if (null == userDto) {
            return false;
        }
        Collection<? extends GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userDto.getPermissions().toArray(new String[0]));
        return authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .filter(StringUtils::hasText)
                .anyMatch(r -> PatternMatchUtils.simpleMatch(permission, r));
    }
}
