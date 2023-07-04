package cn.insectmk.bus.controller;

import cn.insectmk.bus.domain.Customer;
import cn.insectmk.bus.domain.RentVo;
import cn.insectmk.bus.service.CheckService;
import cn.insectmk.bus.service.CustomerService;
import cn.insectmk.bus.service.RentService;
import cn.insectmk.sys.domain.DataGridView;
import cn.insectmk.sys.domain.User;
import cn.insectmk.sys.utils.RandomUtils;
import cn.insectmk.sys.utils.ResultObj;
import cn.insectmk.sys.utils.SysConstant;
import cn.insectmk.sys.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.Map;

/**
 * @Description 汽车出租管理的控制器
 * @Author makun
 * @Date 2023/7/3 21:10
 * @Version 1.0
 */
@RestController
@RequestMapping("rent")
public class RentController {
    @Autowired
    private RentService rentService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CheckService checkService;

    /**
     * 根据出租单号加载检查单的表单数据
     * @param rentid
     * @return
     */
    @RequestMapping("initCheckFormData")
    public Map<String,Object> initCheckFormData(String rentid){
        return this.checkService.initCheckFormData(rentid);
    }

    /**
     * 删除出租单信息
     * @param rentVo
     * @return
     */
    @RequestMapping("deleteRent")
    public ResultObj deleteRent(RentVo rentVo){
        try {
            //删除
            this.rentService.deleteRent(rentVo.getRentid());
            return ResultObj.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 修改出租单信息
     * @param rentVo
     * @return
     */
    @RequestMapping("updateRent")
    public ResultObj updateRent(RentVo rentVo){
        try {
            //修改
            this.rentService.updateRent(rentVo);
            return ResultObj.UPDATE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 查询
     */
    @RequestMapping("loadAllRent")
    public DataGridView loadAllRent(RentVo rentVo){
        return this.rentService.queryAllRent(rentVo);
    }

    /**
     * 保存出租单信息
     * @param rentVo
     * @return
     */
    @RequestMapping("saveRent")
    public ResultObj saveRent(RentVo rentVo) {
        try {
            //设置创建时间
            rentVo.setCreatetime(new Date());
            //设置归还状态
            rentVo.setRentflag(SysConstant.RENT_BACK_FALSE);
            //保存
            this.rentService.addRent(rentVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 初始化添加出租单的表单的数据
     * @param rentVo
     * @return
     */
    @RequestMapping("initRentFrom")
    public RentVo initRentFrom(RentVo rentVo){
        //生成出租单号
        rentVo.setRentid(RandomUtils.createRandomStringUseTime(SysConstant.CAR_ORDER_CZ));
        //设置起租时间
        rentVo.setBegindate(new Date());
        //设置操作员
        User user = (User) WebUtils.getHttpSession().getAttribute("user");
        rentVo.setOpername(user.getRealname());
        return rentVo;
    }

    /**
     *检查身份证号是否存在
     * @param rentVo
     * @return
     */
    @RequestMapping("checkCustomerExist")
    public ResultObj checkCustomerExist(RentVo rentVo){
        Customer customer = customerService.queryCustomerByIdentity(rentVo.getIdentity());
        if(customer!=null){
            return ResultObj.STATUS_TRUE;
        }else {
            return ResultObj.STATUS_FALSE;
        }
    }
}
