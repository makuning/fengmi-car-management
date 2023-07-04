package cn.insectmk.sys.mapper;

import cn.insectmk.sys.domain.Menu;
import cn.insectmk.sys.domain.MenuVo;

import java.util.List;

/**
 * @Description 菜单表持久层访问
 * @Author makun
 * @Date 2023/7/4 16:53
 * @Version 1.0
 */
public interface MenuMapper {
    int updateByPrimaryKeySelective(Menu record);

    int insertSelective(Menu record);

    /**
     * 查询所有菜单
     */
    List<Menu> queryAllMenu(Menu menu);
}