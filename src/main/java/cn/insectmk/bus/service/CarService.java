package cn.insectmk.bus.service;

import cn.insectmk.bus.domain.Car;
import cn.insectmk.bus.domain.CarVo;
import cn.insectmk.sys.domain.DataGridView;

/**
 * @Description 车辆服务接口
 * @Author makun
 * @Date 2023/6/29 14:58
 * @Version 1.0
 */
public interface CarService {
    /**
     * 根据车牌号查询
     * @param carnumber
     * @return
     */
    Car queryCarByCarNumber(String carnumber);

    /**
     * 修改车辆
     * @param carVo
     */
    public void updateCar(CarVo carVo);

    /**
     * 根据id删除车辆
     * @param carnumber
     */
    public void deleteCar(String carnumber);

    /**
     * 查询所有车辆
     *
     * @param carVo
     * @return
     */
    public DataGridView queryAllCar(CarVo carVo);

    /**
     * 添加车辆
     * @param carVo
     */
    public void addCar(CarVo carVo);
}
