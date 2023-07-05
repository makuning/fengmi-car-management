package cn.insectmk.sys.service;

import cn.insectmk.sys.domain.DataGridView;
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
     * 删除菜单
     *
     * @param menuVo
     */
    void deleteMenu(MenuVo menuVo);

    /**
     * 根据pid查询菜单的数量
     **/
    Integer queryMenuByPid(Integer pid);

    /**
     * 修改菜单
     **/
    void updateMenu(MenuVo menuVo);

    /**
     * 添加菜单
     **/
    void addMenu(MenuVo menuVo);

    /**
     * 查询所有菜单
     * @param menuVo
     * @return
     */
    DataGridView queryAllMenu(MenuVo menuVo);

    /**
     * 查询所有的菜单返回List
     * @param menuVo
     * @return
     */
    List<Menu> queryAllMenuForList(MenuVo menuVo);

    List<Menu> queryMenuByUserIdForList(MenuVo menuVo, Integer userid);
}
