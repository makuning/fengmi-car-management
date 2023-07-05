package cn.insectmk.stat.service;

import cn.insectmk.stat.domain.BaseEntity;
import java.util.List;

/**
 * @Description 统计服务接口
 * @Author makun
 * @Date 2023/7/5 13:42
 * @Version 1.0
 */
public interface StatService {
    /**
     * 公司年度月份销售数据
     * @param year
     * @return
     */
    List<Double> loadCompanyYearGradeStatList(String year);

    /**
     * 查询客户地区数据
     * @return
     */
    List<BaseEntity> loadCustomerAreaStatList();
}
