package cn.insectmk.sys.controller;

import cn.insectmk.sys.domain.DataGridView;
import cn.insectmk.sys.domain.LogInfoVo;
import cn.insectmk.sys.service.LogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 日志模块控制器
 * @Author makun
 * @Date 2023/7/5 13:11
 * @Version 1.0
 */
@RestController
@RequestMapping("logInfo")
public class LogInfoController {

    @Autowired
    private LogInfoService logInfoService;

    /**
     * 加载日志列表返DataGridView
     * @param logInfoVo
     * @return
     */
    @RequestMapping("loadAllLogInfo")
    public DataGridView loadAllLogInfo(LogInfoVo logInfoVo){
        return this.logInfoService.queryAllLogInfo(logInfoVo);
    }
}
