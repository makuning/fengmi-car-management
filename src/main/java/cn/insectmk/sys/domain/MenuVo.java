package cn.insectmk.sys.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 菜单视图对象
 * @Author makun
 * @Date 2023/7/4 16:44
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuVo extends Menu {
    private Integer page;
    private Integer limit;
}
