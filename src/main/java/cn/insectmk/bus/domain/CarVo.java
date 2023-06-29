package cn.insectmk.bus.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 车辆视图对象
 * @Author makun
 * @Date 2023/6/29 14:57
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarVo extends Car {

    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;

    //接受多个id
    private String [] ids;
}

