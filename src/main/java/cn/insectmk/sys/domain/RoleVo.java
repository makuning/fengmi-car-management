package cn.insectmk.sys.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 角色视图对象
 * @Author makun
 * @Date 2023/7/4 19:15
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleVo extends Role {
    /**
     * 分页参数
     * */
    private Integer page;
    private Integer limit;
    //接收多个角色id
    private Integer []ids;
}
