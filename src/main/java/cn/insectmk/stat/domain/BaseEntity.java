package cn.insectmk.stat.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 报表实体对象
 * @Author makun
 * @Date 2023/7/5 13:41
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {
    private String name;
    private Double value;
}
