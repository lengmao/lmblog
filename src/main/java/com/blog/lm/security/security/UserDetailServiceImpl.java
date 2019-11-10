package com.blog.lm.security.security;

import com.blog.lm.system.entity.SysUser;
import com.blog.lm.system.service.SysUserRoleService;
import com.blog.lm.system.service.SysUserService;
import com.blog.lm.common.constant.CommonConstant;
import com.blog.lm.common.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author xus
 * @Date 2019/11/6 14:04
 * @Description TODO
 **/
@Slf4j
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    SysUserService userService;
    @Autowired
    SysUserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto = userService.getUserByName(username);
        if (null == userDto.getSysUser()) {
            throw new UsernameNotFoundException("用户不存在！");
        }
        SysUser user = userDto.getSysUser();
        Set<String> authSet = new LinkedHashSet<>();
        if (0 != userDto.getRoleList().size()) {
            //获取角色
            userDto.getRoleList().stream().forEach(role -> authSet.add("ROLE_" + role));
            //获取资源
            authSet.addAll(userDto.getPermissions());
        }
        Collection<? extends GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(authSet.toArray(new String[0]));
        return new MyUser(user.getUserName(), user.getUserPass(), CommonConstant.STATUS_NORMAL.equals(user.getStatus()),
                true, true, true, authorities);
    }
}
