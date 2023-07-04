package cn.insectmk.bus.service;

import java.util.Map;

/**
 * @Description 入库检查表服务接口
 * @Author makun
 * @Date 2023/7/4 15:34
 * @Version 1.0
 */
public interface CheckService {
    /**
     * 根据出租单号加载检测单的表单数据
     * @param rentid
     * @return
     */
    Map<String,Object> initCheckFormData(String rentid);
}
