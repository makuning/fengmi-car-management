package cn.insectmk.bus.service.impl;

import cn.insectmk.bus.domain.*;
import cn.insectmk.bus.mapper.CarMapper;
import cn.insectmk.bus.mapper.CheckMapper;
import cn.insectmk.bus.mapper.CustomerMapper;
import cn.insectmk.bus.mapper.RentMapper;
import cn.insectmk.bus.service.CheckService;
import cn.insectmk.sys.domain.User;
import cn.insectmk.sys.utils.RandomUtils;
import cn.insectmk.sys.utils.SysConstant;
import cn.insectmk.sys.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 入库检查服务接口实现类
 * @Author makun
 * @Date 2023/7/4 15:34
 * @Version 1.0
 */
@Service
public class CheckServiceImpl implements CheckService {
    @Autowired
    private CheckMapper checkMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private RentMapper rentMapper;
    @Autowired
    private CarMapper carMapper;

    /**
     * 保存检查单数据
     * @param checkVo
     */
    @Override
    public void addCheck(CheckVo checkVo) {
        this.checkMapper.insertSelective(checkVo);
        //更改出租单的状态
        Rent rent = this.rentMapper.selectByPrimaryKey(checkVo.getRentid());
        //更改为已归还
        rent.setRentflag(SysConstant.RENT_BACK_TRUE);
        this.rentMapper.updateByPrimaryKeySelective(rent);
        //更改汽车的状态
        Car car = this.carMapper.selectByPrimaryKey(rent.getCarnumber());
        //更改汽车状态为未出租
        car.setIsrenting(SysConstant.RENT_CAR_FALSE);
        this.carMapper.updateByPrimaryKeySelective(car);
    }

    @Override
    public Map<String, Object> initCheckFormData(String rentid) {
        //查询出租单
        Rent rent = this.rentMapper.selectByPrimaryKey(rentid);
        //查询客户
        Customer customer = this.customerMapper.selectByPrimaryKey(rent.getIdentity());
        //查询车辆
        Car car = this.carMapper.selectByPrimaryKey(rent.getCarnumber());
        //组装check
        Check check = new Check();
        check.setCheckid(RandomUtils.createRandomStringUseTime(SysConstant.CAR_ORDER_JC));
        check.setRentid(rentid);
        check.setCheckdate(new Date());
        User user = (User) WebUtils.getHttpSession().getAttribute("user");
        check.setOpername(user.getRealname());
        Map<String, Object> map = new HashMap<>();
        map.put("rent", rent);
        map.put("customer", customer);
        map.put("car", car);
        map.put("check", check);

        return map;
    }
}
