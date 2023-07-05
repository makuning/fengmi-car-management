package cn.insectmk.stat.service.impl;

import cn.insectmk.stat.domain.BaseEntity;
import cn.insectmk.stat.mapper.StatMapper;
import cn.insectmk.stat.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Description 统计服务接口实现类
 * @Author makun
 * @Date 2023/7/5 13:43
 * @Version 1.0
 */
@Service
public class StatServiceImpl implements StatService {
    @Autowired
    private StatMapper statMapper;

    /**
     * 查询客户地区统计数据
     * @return
     */
    @Override
    public List<BaseEntity> loadCustomerAreaStatList() {
        return this.statMapper.queryCustomerAreaStat();
    }
}
