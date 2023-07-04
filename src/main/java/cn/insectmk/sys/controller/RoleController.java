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
     * 加载角色列表返回DataGridView
     */
    @RequestMapping("loadAllRole")
    public DataGridView loadAllRole(RoleVo roleVo) {
        return this.roleService.queryAllRole(roleVo);
    }
}