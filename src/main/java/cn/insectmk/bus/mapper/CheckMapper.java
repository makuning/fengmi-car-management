package cn.insectmk.bus.mapper;

import cn.insectmk.bus.domain.Check;
import cn.insectmk.bus.domain.CheckVo;

import java.util.List;

/**
 * @Description 检查单持久层访问接口
 * @Author makun
 * @Date 2023/7/4 15:37
 * @Version 1.0
 */
public interface CheckMapper {
    int deleteByPrimaryKey(String checkid);
    int updateByPrimaryKeySelective(Check record);
    //查询
    List<Check> queryAllCheck(Check check);
    void insertSelective(CheckVo checkVo);
}
