package cn.insectmk.bus.mapper;

import cn.insectmk.bus.domain.CheckVo;

/**
 * @Description 检查单持久层访问接口
 * @Author makun
 * @Date 2023/7/4 15:37
 * @Version 1.0
 */
public interface CheckMapper {
    void insertSelective(CheckVo checkVo);
}
