package cn.insectmk.bus.service.impl;

import cn.insectmk.bus.domain.Car;
import cn.insectmk.bus.domain.Rent;
import cn.insectmk.bus.domain.RentVo;
import cn.insectmk.bus.mapper.CarMapper;
import cn.insectmk.bus.mapper.RentMapper;
import cn.insectmk.bus.service.RentService;
import cn.insectmk.sys.domain.DataGridView;
import cn.insectmk.sys.utils.SysConstant;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 租借服务接口实现
 * @Author makun
 * @Date 2023/7/3 21:16
 * @Version 1.0
 */
@Service
public class RentServiceImpl implements RentService {
    @Autowired
    private RentMapper rentMapper;
    @Autowired
    private CarMapper carMapper;

    @Override
    public void deleteRent(String rentId) {
        //更改汽车状态，将已出租的状态转换成未出租的状态
        Rent rent = rentMapper.selectByPrimaryKey(rentId);
        Car car = new Car();
        car.setCarnumber(rent.getCarnumber());
        //转换成未出租的状态
        car.setIsrenting(SysConstant.RENT_CAR_FALSE);
        carMapper.updateByPrimaryKeySelective(car);
        this.rentMapper.deleteByPrimaryKey(rentId);
    }

    @Override
    public void updateRent(RentVo rentVo) {
        this.rentMapper.updateByPrimaryKeySelective(rentVo);
    }

    @Override
    public DataGridView queryAllRent(RentVo rentVo) {
        Page<Object> page = PageHelper.startPage(rentVo.getPage(),rentVo.getLimit());
        List<Rent> data = this.rentMapper.queryAllRent(rentVo);
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public void addRent(RentVo rentVo) {
        this.rentMapper.insertSelective(rentVo);
        //更改车辆出租的状态
        Car car = new Car();
        car.setCarnumber(rentVo.getCarnumber());
        //设置状态为已出租
        car.setIsrenting(SysConstant.RENT_BACK_TRUE);
        carMapper.updateByPrimaryKeySelective(car);
    }

    @Override
    public Rent queryRentByRentId(String rentid) {
        return rentMapper.selectByPrimaryKey(rentid);
    }

}
