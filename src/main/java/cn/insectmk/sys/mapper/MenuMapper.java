package cn.insectmk.sys.mapper;

import cn.insectmk.sys.domain.Menu;
import cn.insectmk.sys.domain.MenuVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description 菜单表持久层访问
 * @Author makun
 * @Date 2023/7/4 16:53
 * @Version 1.0
 */
public interface MenuMapper {
    /**
     * 根据角色ID查询菜单
     * @param available
     * @param roleid
     * @return
     */
    List<Menu> queryMenuByRoleId(@Param("available") Integer available, @Param("rid") Integer 	  roleid);

    int deleteByPrimaryKey(Integer id);

    /**
     * 根据pid查询菜单数量
     * @param pid
     * @return
     */
    Integer queryMenuByPid(@Param("pid") Integer pid);

    int updateByPrimaryKeySelective(Menu record);

    int insertSelective(Menu record);

    /**
     * 查询所有菜单
     */
    List<Menu> queryAllMenu(Menu menu);
}