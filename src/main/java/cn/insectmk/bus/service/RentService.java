package cn.insectmk.bus.service;

import cn.insectmk.bus.domain.Rent;
import cn.insectmk.bus.domain.RentVo;
import cn.insectmk.sys.domain.DataGridView;

/**
 * @Description 租借服务接口
 * @Author makun
 * @Date 2023/7/3 21:16
 * @Version 1.0
 */
public interface RentService {


    /**
     * 删除出租单
     * @param rentId
     */
    void deleteRent(String rentId);

    /**
     * 修改出租单
     * @param rentVo
     */
    void updateRent(RentVo rentVo);

    /**
     * 查询
     * @param rentVo
     */
    DataGridView queryAllRent(RentVo rentVo);

    void addRent(RentVo rentVo);

    /**
     * 根据出租单号查询出租单信息
     * @param rentid
     * @return
     */
    Rent queryRentByRentId(String rentid);
}