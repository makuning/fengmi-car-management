package cn.insectmk.sys.controller;

import cn.insectmk.bus.domain.CustomerVo;
import cn.insectmk.sys.domain.DataGridView;
import cn.insectmk.sys.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 客户控制器
 * @Author makun
 * @Date 2023/6/28 16:53
 * @Version 1.0
 */
@RestController  //以json形式响应数据
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 加载客户列表返回DataGridView
     * @param customerVo
     * @return
     */
    @RequestMapping("loadAllCustomer")
    public DataGridView loadAllCustomer(CustomerVo customerVo){
        return customerService.queryAllCustomer(customerVo);
    }
}
