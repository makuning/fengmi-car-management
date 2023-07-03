package cn.insectmk.bus.mapper;

import cn.insectmk.bus.domain.Rent;

import java.util.List;

/**
 * @Description 租借表持久层访问
 * @Author makun
 * @Date 2023/7/3 21:17
 * @Version 1.0
 */
public interface RentMapper {
    /**
     * @return 查询
     */
    List<Rent> queryAllRent(Rent rent);
    int insertSelective(Rent record);
}