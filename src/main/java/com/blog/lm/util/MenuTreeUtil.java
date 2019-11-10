package com.blog.lm.util;

import com.blog.lm.system.entity.SysMenu;
import org.springframework.util.StringUtils;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author xus
 * @Date 2019/11/9 17:52
 * @Description TODO
 **/
public class MenuTreeUtil {


    /**
     * @param menus
     * @return
     */
    public static List<SysMenu> treeNode(List<SysMenu> menus) {

        //找出所有的一级菜单
        List<SysMenu> root = menus.stream()
                .filter(menu -> menu.getMenuPid().equals(0))
                .collect(Collectors.toList());
        root.stream().forEach(menu -> menu.setChild(getChild(menu.getId(), menus)));

        return root;
    }


    private static List<SysMenu> getChild(Integer id, List<SysMenu> root) {
        List<SysMenu> childList = root.stream()
                .filter(menu -> !StringUtils.isEmpty(menu.getMenuPid()))
                .filter(child -> child.getMenuPid().equals(id))
                .collect(Collectors.toList());

        childList.stream()
                .filter(child -> "".equals(child.getMenuUrl()))
                .forEach(m -> m.setChild(getChild(m.getId(), root)));
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }

}
