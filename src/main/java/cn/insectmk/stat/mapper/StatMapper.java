package cn.insectmk.stat.mapper;

import cn.insectmk.stat.domain.BaseEntity;

import java.util.List;

/**
 * @Description 统计服务持久层访问
 * @Author makun
 * @Date 2023/7/5 13:44
 * @Version 1.0
 */
public interface StatMapper {
    /**
     * 查询公司年度业务销售额数据
     * @param year
     * @return
     */
    List<Double> queryCompanyYearGradeStat(String year);

    /**
     * 查询客户地区的数据
     * @return
     */
    List<BaseEntity> queryCustomerAreaStat();
}
