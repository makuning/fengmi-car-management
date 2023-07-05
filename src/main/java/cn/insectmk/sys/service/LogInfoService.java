package cn.insectmk.sys.service;

import cn.insectmk.sys.domain.DataGridView;
import cn.insectmk.sys.domain.LogInfoVo;

/**
 * @Description 日志信息模块服务接口
 * @Author makun
 * @Date 2023/7/5 13:12
 * @Version 1.0
 */
public interface LogInfoService {
    /**
     * 批量删除日志
     * @param ids
     */
    public void deleteBatchLogInfo(Integer[] ids);

    /**
     * 根据id删除日志
     * @param logInfoid
     */
    public void deleteLogInfo(Integer logInfoid);


    /**
     * 查询所有日志
     * @param logInfoVo
     * @return
     */
    DataGridView queryAllLogInfo(LogInfoVo logInfoVo);
}
