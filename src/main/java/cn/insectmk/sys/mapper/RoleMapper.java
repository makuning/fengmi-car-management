package cn.insectmk.sys.mapper;

import cn.insectmk.sys.domain.Role;

import java.util.List;

/**
 * @Description 角色表持久层访问
 * @Author makun
 * @Date 2023/7/4 19:18
 * @Version 1.0
 */
public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleid);

    /**
     * 根据角色id删除sys_role_menu里面的数据
     * @param roleid
     */
    void deleteRoleMenuByRid(Integer roleid);

    /**
     * 根据角色id删除sys_role_user里面的数据
     * @param roleid
     */
    void deleteRoleUserByRid(Integer roleid);

    int updateByPrimaryKeySelective(Role record);

    int insertSelective(Role record);

    /**
     * 查询角色
     * @param role
     * @return
     */
    List<Role> queryAllRole(Role role);
}