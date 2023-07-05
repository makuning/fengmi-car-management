package cn.insectmk.sys.mapper;

import cn.insectmk.sys.domain.LogInfo;

import java.util.List;

/**
 * @Description 日志信息持久层访问接口
 * @Author makun
 * @Date 2023/7/5 13:14
 * @Version 1.0
 */
public interface LogInfoMapper {
    int deleteByPrimaryKey(Integer id);

    /**
     * 查询日志
     * @param logInfo
     * @return
     */
    List<LogInfo> queryAllLogInfo(LogInfo logInfo);
}
