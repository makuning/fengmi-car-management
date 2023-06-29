package cn.insectmk.bus.mapper;

import cn.insectmk.bus.domain.Car;
import cn.insectmk.bus.domain.CarVo;

import java.util.List;

/**
 * @Description 车辆持久层访问接口
 * @Author makun
 * @Date 2023/6/29 14:59
 * @Version 1.0
 */
public interface CarMapper {
    int insertSelective(Car record);

    List<Car> queryAllCar(CarVo carVo);
}
