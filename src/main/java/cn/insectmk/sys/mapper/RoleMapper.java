package cn.insectmk.sys.mapper;

import cn.insectmk.sys.domain.Menu;
import cn.insectmk.sys.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description 角色表持久层访问
 * @Author makun
 * @Date 2023/7/4 19:18
 * @Version 1.0
 */
public interface RoleMapper {
    List<Role> queryRoleByUid(@Param("available") Integer availableTrue, @Param("uid") Integer userid);

    /**
     * 根据用户id删除sys_role_user里面的数据
     * @param userid
     */
    void deleteRoleUserByUid(Integer userid);

    /**
     * 保存角色和菜单的关系sys_role_menu
     * @param rid
     * @param mid
     */
    void insertRoleMenu(@Param("rid") Integer rid, @Param("mid") Integer mid);

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