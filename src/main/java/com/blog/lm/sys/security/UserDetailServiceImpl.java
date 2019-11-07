package com.blog.lm.sys.security;

import com.blog.lm.busi.entity.SysUser;
import com.blog.lm.busi.service.SysUserRoleService;
import com.blog.lm.busi.service.SysUserService;
import com.blog.lm.common.constant.CommonConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

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
        SysUser user = userService.getUserByName(username);

        Set<GrantedAuthority> authSet= new LinkedHashSet<>();
        Collection<? extends GrantedAuthority> authorities= AuthorityUtils.createAuthorityList(authSet.toArray(new String[0]));
        return new MyUser(user.getUserName(),user.getUserPass(), CommonConstant.STATUS_NORMAL.equals(user.getStatus()),true,true,true,authorities);
    }
}
