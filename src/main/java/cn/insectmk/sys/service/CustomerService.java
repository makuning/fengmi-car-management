package cn.insectmk.sys.service;

import cn.insectmk.bus.domain.CustomerVo;
import cn.insectmk.sys.domain.DataGridView;

/**
 * @Description 客户服务类
 * @Author makun
 * @Date 2023/6/28 16:54
 * @Version 1.0
 */
public interface CustomerService {

    /**
     * 删除客户
     * @param identity
     */
    public void deleteCustomer(String identity);

    /**
     * 查询所有客户
     * @param customerVo
     * @return
     */
    public DataGridView queryAllCustomer(CustomerVo customerVo);

    /**
     * 添加客户
     * @param customerVo
     */
    public void addCustomer(CustomerVo customerVo);
}
