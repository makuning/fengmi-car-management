package cn.insectmk.sys.service.impl;

import cn.insectmk.sys.domain.*;
import cn.insectmk.sys.mapper.MenuMapper;
import cn.insectmk.sys.mapper.RoleMapper;
import cn.insectmk.sys.mapper.UserMapper;
import cn.insectmk.sys.service.MenuService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description 菜单服务接口实现类
 * @Author makun
 * @Date 2023/7/4 16:52
 * @Version 1.0
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    /**
     * 删除菜单
     * @param menuVo
     */
    @Override
    public void deleteMenu(MenuVo menuVo) {
        //删除菜单的数据
        this.menuMapper.deleteByPrimaryKey(menuVo.getId());
        //根据id删除sys_role_menu里面的数据 TODO
        //this.menuMapper.deleteRoleMenuByMid(menuVo.getId());
    }

    /**
     * 根据pid查询菜单的数量
     * @param pid
     * @return
     */
    @Override
    public Integer queryMenuByPid(Integer pid) {
        return this.menuMapper.queryMenuByPid(pid);
    }

    /**
     * 修改菜单
     * @param menuVo
     */
    @Override
    public void updateMenu(MenuVo menuVo) {
        this.menuMapper.updateByPrimaryKeySelective(menuVo);
    }

    /**
     * 添加菜单
     * @param menuVo
     */
    @Override
    public void addMenu(MenuVo menuVo) {
        this.menuMapper.insertSelective(menuVo);
    }

    /**
     * 查询所有菜单的实现类
     * @param menuVo
     * @return
     */
    @Override
    public DataGridView queryAllMenu(MenuVo menuVo) {
        Page<Object> page = PageHelper.startPage(menuVo.getPage(),menuVo.getLimit());
        List<Menu> data = this.menuMapper.queryAllMenu(menuVo);
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public List<Menu> queryAllMenuForList(MenuVo menuVo) {
        return menuMapper.queryAllMenu(menuVo);
    }

    @Override
    public List<Menu> queryMenuByUserIdForList(MenuVo menuVo, Integer userid) {
        List<Role> roles = userMapper.queryRolesByPrimaryKey(userid);
        List<Menu> menus = null;
        Set<Menu> finalMenu = new HashSet<>();
        for (Role role : roles) {
            menus = menuMapper.queryMenuByRoleId(role.getAvailable(), role.getRoleid());
            finalMenu.addAll(menus);
        }
        return new ArrayList<>(finalMenu);
    }
}
