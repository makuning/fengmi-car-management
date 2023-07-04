package cn.insectmk.sys.controller;

/**
 * @Description 系统功能页面跳转控制器
 * @Author makun
 * @Date 2023/7/4 16:58
 * @Version 1.0
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转控制器
 */
@Controller
@RequestMapping("sys")
public class SysController {
    /**
     * 跳转到菜单管理的左边的菜单树页面
     * @return
     */
    @RequestMapping("toMenuRight")
    public String toMenuRight(){
        return "system/menu/MenuRight";
    }

    /**
     * 跳转到菜单管理的右边的菜单树页面
     * @return
     */
    @RequestMapping("toMenuLeft")
    public String toMenuLeft(){
        return "system/menu/MenuLeft";
    }

    /**
     * @return 跳转到菜单管理
     */
    @RequestMapping("toMenuManager")
    public String toMenuManager(){
        return "system/menu/menuManager";
    }

    @RequestMapping("dTreeDemo")
    public String test(){
        return "system/menu/dTreeDemo";
    }
}