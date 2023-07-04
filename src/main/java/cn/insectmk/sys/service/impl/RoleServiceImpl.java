package cn.insectmk.sys.service.impl;

import cn.insectmk.sys.domain.*;
import cn.insectmk.sys.mapper.MenuMapper;
import cn.insectmk.sys.mapper.RoleMapper;
import cn.insectmk.sys.service.RoleService;
import cn.insectmk.sys.utils.SysConstant;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 角色模块服务接口实现类
 * @Author makun
 * @Date 2023/7/4 19:17
 * @Version 1.0
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public void saveRoleMenu(RoleVo roleVo) {
        Integer rid=roleVo.getRoleid();
        Integer [] mids=roleVo.getIds();
        //根据rid删除sys_role_menu里面的所有数据
        this.roleMapper.deleteRoleMenuByRid(rid);
        //保存角色和菜单的关系
        for (Integer mid : mids) {
            this.roleMapper.insertRoleMenu(rid,mid);
        }
    }

    @Override
    public DataGridView initRoleMenuTreeJson(Integer roleid) {
        //查询所有的可用的菜单
        Menu menu = new Menu();
        menu.setAvailable(SysConstant.AVAILABLE_TRUE);
        List<Menu> allMenu = menuMapper.queryAllMenu(menu);
        //根据角色ID查询当前角色拥有的菜单
        List<Menu> roleMenu = menuMapper.queryMenuByRoleId(SysConstant.AVAILABLE_TRUE,roleid);

        List<TreeNode> data = new ArrayList<>();
        for (Menu m1 : allMenu) {
            String checkArr = SysConstant.CODE_ZERO+"";
            for (Menu m2 : roleMenu) {
                if (m1.getId()==m2.getId()){
                    checkArr=SysConstant.CODE_ONE+"";
                    break;
                }
            }
            Integer id = m1.getId();
            Integer pid = m1.getPid();
            String title = m1.getTitle();
            Boolean spread = m1.getSpread()==SysConstant.SPREAD_TRUE?true:false;
            data.add(new TreeNode(id,pid,title,spread,checkArr));
        }

        return new DataGridView(data);
    }

    /**
     * 根据前台页面传来的数组批量删除角色
     * @param ids
     */
    @Override
    public void deleteBatchRole(Integer[] ids) {
        for (Integer rid : ids){
            deleteRole(rid);
        }
    }

    /**
     * 根据角色roleid单个删除角色
     * @param roleid
     */
    @Override
    public void deleteRole(Integer roleid) {
        //删除角色表的数据
        this.roleMapper.deleteByPrimaryKey(roleid);
        //根据角色id删除sys_role_menu里面的数据
        //this.roleMapper.deleteRoleMenuByRid(roleid);
        //根据角色id删除sys_role_user里面的数据 //TODO
        //this.roleMapper.deleteRoleUserByRid(roleid);

    }

    /**
     * 更新角色
     * @param roleVo
     */
    @Override
    public void updateRole(RoleVo roleVo) {
        this.roleMapper.updateByPrimaryKeySelective(roleVo);
    }

    /**
     * 添加角色
     * @param roleVo
     */
    @Override
    public void addRole(RoleVo roleVo) {
        this.roleMapper.insertSelective(roleVo);
    }

    @Override
    public DataGridView queryAllRole(RoleVo roleVo) {
        Page<Object> page = PageHelper.startPage(roleVo.getPage(),roleVo.getLimit());
        List<Role> data = this.roleMapper.queryAllRole(roleVo);
        return new DataGridView(page.getTotal(),data);
    }
}