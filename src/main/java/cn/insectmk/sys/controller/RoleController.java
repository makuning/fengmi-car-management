package cn.insectmk.sys.controller;

/**
 * @Description 角色模块控制器
 * @Author makun
 * @Date 2023/7/4 19:16
 * @Version 1.0
 */

import cn.insectmk.sys.domain.DataGridView;
import cn.insectmk.sys.domain.RoleVo;
import cn.insectmk.sys.service.RoleService;
import cn.insectmk.sys.utils.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色控制器
 * @author qianfeng
 * @date 2020/2/17 14:36
 */
@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 保存角色和菜单的关系
     */
    @RequestMapping("saveRoleMenu")
    public ResultObj saveRoleMenu(RoleVo roleVo) {
        try {

            this.roleService.saveRoleMenu(roleVo);
            return ResultObj.DISPATCH_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DISPATCH_ERROR;

        }
    }

    /**
     * 加载角色管理分配菜单的json
     */
    @RequestMapping("initRoleMenuTreeJson")
    public DataGridView initRoleMenuTreeJson(Integer roleid) {
        return this.roleService.initRoleMenuTreeJson(roleid);
    }

    /**
     * 批量删除角色
     * @param roleVo
     * @return
     */
    @RequestMapping("deleteBatchRole")
    public ResultObj deleteBatchRole(RoleVo roleVo) {
        try {
            this.roleService.deleteBatchRole(roleVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 删除角色
     */
    @RequestMapping("deleteRole")
    public ResultObj deleteRole(RoleVo roleVo) {
        try {
            this.roleService.deleteRole(roleVo.getRoleid());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 修改角色
     */
    @RequestMapping("updateRole")
    public ResultObj updateRole(RoleVo roleVo) {
        try {
            this.roleService.updateRole(roleVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 添加角色
     * @param roleVo
     * @return
     */
    @RequestMapping("addRole")
    public ResultObj addRole(RoleVo roleVo) {
        try {
            this.roleService.addRole(roleVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 加载角色列表返回DataGridView
     */
    @RequestMapping("loadAllRole")
    public DataGridView loadAllRole(RoleVo roleVo) {
        return this.roleService.queryAllRole(roleVo);
    }
}