package cn.insectmk.bus.service;

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
     * 查询
     * @param rentVo
     */
    DataGridView queryAllRent(RentVo rentVo);

    void addRent(RentVo rentVo);
}