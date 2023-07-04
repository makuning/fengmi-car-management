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