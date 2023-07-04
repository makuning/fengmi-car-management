package cn.insectmk.sys.service;

import cn.insectmk.sys.domain.DataGridView;
import cn.insectmk.sys.domain.RoleVo;

/**
 * @Description 角色模块服务接口
 * @Author makun
 * @Date 2023/7/4 19:17
 * @Version 1.0
 */
public interface RoleService {
    /**
     * 保存角色和菜单的关系
     * @param roleVo
     */
    void saveRoleMenu(RoleVo roleVo);

    /**
     * 加载角色管理分配菜单的json
     * @param roleid
     * @return
     */
    DataGridView initRoleMenuTreeJson(Integer roleid);

    /**
     * 批量删除角色
     * @param ids
     */
    void deleteBatchRole(Integer[] ids);

    /**
     * 根据id删除角色
     * @param roleid
     */
    void deleteRole(Integer roleid);

    /**
     * 修改角色
     * @param roleVo
     */
    void updateRole(RoleVo roleVo);

    /**
     * 添加角色
     * @param roleVo
     */
    void addRole(RoleVo roleVo);

    /**
     * 查询所有角色
     * @param roleVo
     * @return
     */
    DataGridView queryAllRole(RoleVo roleVo);

}