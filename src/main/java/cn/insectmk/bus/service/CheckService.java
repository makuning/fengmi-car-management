package cn.insectmk.bus.service;

import cn.insectmk.bus.domain.CheckVo;
import cn.insectmk.sys.domain.DataGridView;
import java.util.Map;

/**
 * @Description 入库检查表服务接口
 * @Author makun
 * @Date 2023/7/4 15:34
 * @Version 1.0
 */
public interface CheckService {
    /**
     * 批量删除检查单
     * @param ids
     */
    void deleteBatchCheck(String[] ids);

    /**
     * 删除检查单
     * @param checkVo
     */
    void deleteCheck(CheckVo checkVo);

    /**
     * 更新检查单
     * @param checkVo
     */
    void updateCheck(CheckVo checkVo);

    /**
     * 保存检查单数据
     * @param checkVo
     */
    void addCheck(CheckVo checkVo);

    /**
     * 根据出租单号加载检测单的表单数据
     * @param rentid
     * @return
     */
    Map<String,Object> initCheckFormData(String rentid);

    /**
     * 查询所有检查单
     * @return
     */
    DataGridView queryAllCheck(CheckVo checkVo);
}
