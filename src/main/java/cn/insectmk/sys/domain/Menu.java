package cn.insectmk.sys.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 菜单实体类
 * @Author makun
 * @Date 2023/7/4 16:43
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    private Integer id;
    private Integer pid;
    private String title;
    private String href;
    private Integer spread;
    private String target;
    private String icon;
    private Integer available;
}
