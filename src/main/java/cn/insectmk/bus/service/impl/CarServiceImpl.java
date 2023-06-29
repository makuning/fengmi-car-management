package cn.insectmk.bus.service.impl;

import cn.insectmk.bus.domain.Car;
import cn.insectmk.bus.domain.CarVo;
import cn.insectmk.bus.mapper.CarMapper;
import cn.insectmk.bus.service.CarService;
import cn.insectmk.sys.domain.DataGridView;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Description 车辆服务实现类
 * @Author makun
 * @Date 2023/6/29 14:58
 * @Version 1.0
 */
@Service
public class CarServiceImpl implements CarService {
    /**
     * 添加一个车辆
     * @param carVo
     */
    @Override
    public void addCar(CarVo carVo) {
        this.carMapper.insertSelective(carVo);
    }

    @Autowired
    private CarMapper carMapper;

    /**
     * 查询所有信息
     * @param carVo
     * @return
     */
    @Override
    public DataGridView queryAllCar(CarVo carVo) {
        Page<Object> page = PageHelper.startPage(carVo.getPage(),carVo.getLimit());
        List<Car> data = this.carMapper.queryAllCar(carVo);

        return new DataGridView(page.getTotal(),data);
    }
}
