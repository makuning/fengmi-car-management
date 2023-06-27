package cn.insectmk.sys.controller;

/**
 * @Description 工作台控制器
 * @Author makun
 * @Date 2023/6/27 19:52
 * @Version 1.0
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 工作台控制器
 */
@Controller
@RequestMapping("desk")
public class DeskController {
    /**
     * 跳转到工作台的页面
     * @return
     */
    @RequestMapping("toDeskManager")
    public String toDeskManager(){
        return "system/main/deskManager";
    }
}
