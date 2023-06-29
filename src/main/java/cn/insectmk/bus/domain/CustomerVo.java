package cn.insectmk.bus.domain;

import cn.insectmk.bus.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

/**
 * @Description 客户视图对象
 * @Author makun
 * @Date 2023/6/28 16:53
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerVo extends Customer {
    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;

    //接受多个id
    private String [] ids;
}
