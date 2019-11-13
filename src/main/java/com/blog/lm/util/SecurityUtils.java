package com.blog.lm.util;

import com.blog.lm.common.dto.UserDto;
import com.blog.lm.system.entity.SysUser;
import com.blog.lm.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Author xus
 * @Date 2019/11/13 15:17
 * @Description TODO
 **/
public class SecurityUtils {

    @Autowired
    private static SysUserService userService;
    private static String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    public static UserDto getUserAllInfo() {
        return userService.getUserByName(username);
    }

    public static SysUser getUserInfo() {
        return userService.getUserByName(username).getSysUser();
    }
}
