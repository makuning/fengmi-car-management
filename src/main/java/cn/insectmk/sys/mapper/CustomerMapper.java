package cn.insectmk.sys.mapper;

import cn.insectmk.bus.domain.Customer;

import java.util.List;

/**
 * @Description 客户持久层访问接口
 * @Author makun
 * @Date 2023/6/28 16:56
 * @Version 1.0
 */
public interface CustomerMapper {

    /**
     * 查询
     * @param customer
     * @return
     */
    List<Customer> queryAllCustomer(Customer customer);
}
