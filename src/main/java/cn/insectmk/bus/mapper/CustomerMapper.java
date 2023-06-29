package cn.insectmk.bus.mapper;

import cn.insectmk.bus.domain.Customer;

import java.util.List;

/**
 * @Description 客户持久层访问接口
 * @Author makun
 * @Date 2023/6/28 16:56
 * @Version 1.0
 */
public interface CustomerMapper {
    int updateByPrimaryKeySelective(Customer record);
    int deleteByPrimaryKey(String identity);

    int insertSelective(Customer record);

    /**
     * 查询
     * @param customer
     * @return
     */
    List<Customer> queryAllCustomer(Customer customer);
}
