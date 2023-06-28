package cn.insectmk.sys.controller;

import cn.insectmk.bus.domain.CustomerVo;
import cn.insectmk.sys.domain.DataGridView;
import cn.insectmk.sys.service.CustomerService;
import cn.insectmk.sys.utils.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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
     * 修改一个客户
     * @param customerVo
     * @return
     */
    @RequestMapping("updateCustomer")
    public ResultObj updateCustomer(CustomerVo customerVo){
        try{
            this.customerService.updateCustomer(customerVo);
            return ResultObj.UPDATE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 删除一个客户
     * @param customerVo
     * @return
     */
    @RequestMapping("deleteCustomer")
    public ResultObj deleteCustomer(CustomerVo customerVo){
        try {
            this.customerService.deleteCustomer(customerVo.getIdentity());
            return ResultObj.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 加载客户列表返回DataGridView
     * @param customerVo
     * @return
     */
    @RequestMapping("loadAllCustomer")
    public DataGridView loadAllCustomer(CustomerVo customerVo){
        return customerService.queryAllCustomer(customerVo);
    }

    /**
     * 添加客户
     * @param customerVo
     * @return
     */
    @RequestMapping("addCustomer")
    public ResultObj addCustomer(CustomerVo customerVo){
        try{
            customerVo.setCreatetime(new Date());
            this.customerService.addCustomer(customerVo);
            return ResultObj.ADD_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }
}
