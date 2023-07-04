package cn.insectmk.sys.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 角色
 * @Author makun
 * @Date 2023/7/4 19:14
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Integer roleid;
    private String rolename;
    private String roledesc;
    private Integer available;
}
