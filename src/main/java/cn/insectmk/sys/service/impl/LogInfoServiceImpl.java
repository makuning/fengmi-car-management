package cn.insectmk.sys.service.impl;

import cn.insectmk.sys.domain.DataGridView;
import cn.insectmk.sys.domain.LogInfo;
import cn.insectmk.sys.domain.LogInfoVo;
import cn.insectmk.sys.mapper.LogInfoMapper;
import cn.insectmk.sys.service.LogInfoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Description 日志模块服务接口实现类
 * @Author makun
 * @Date 2023/7/5 13:13
 * @Version 1.0
 */
@Service
public class LogInfoServiceImpl implements LogInfoService {
    @Autowired
    private LogInfoMapper logInfoMapper;

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void deleteBatchLogInfo(Integer[] ids) {
        for (Integer id:ids) {
            deleteLogInfo(id);
        }
    }

    /**
     * 删除日志
     * @param logInfoid
     */
    @Override
    public void deleteLogInfo(Integer logInfoid) {
        this.logInfoMapper.deleteByPrimaryKey(logInfoid);
    }

    /**
     * 查询所有日志
     * @param logInfoVo
     * @return
     */
    @Override
    public DataGridView queryAllLogInfo(LogInfoVo logInfoVo) {
        Page<Object> page = PageHelper.startPage(logInfoVo.getPage(), logInfoVo.getLimit());
        List<LogInfo> data = this.logInfoMapper.queryAllLogInfo(logInfoVo);
        return new DataGridView(page.getTotal(),data);
    }
}
