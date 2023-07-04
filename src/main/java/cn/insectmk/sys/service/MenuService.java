package cn.insectmk.sys.service;

import cn.insectmk.sys.domain.Menu;
import cn.insectmk.sys.domain.MenuVo;
import java.util.List;

/**
 * @Description 菜单服务接口
 * @Author makun
 * @Date 2023/7/4 16:52
 * @Version 1.0
 */
public interface MenuService {

    /**
     * 查询所有的菜单返回List
     * @param menuVo
     * @return
     */
    List<Menu> queryAllMenuForList(MenuVo menuVo);
}