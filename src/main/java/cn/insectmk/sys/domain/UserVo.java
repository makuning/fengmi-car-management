package cn.insectmk.sys.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 用户视图对象，用于在页面展示用户信息
 * @Author makun
 * @Date 2023/6/27 19:37
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo extends User {
    private Integer page;
    private Integer limit;
    private String code;
    private Integer [] ids;
}
