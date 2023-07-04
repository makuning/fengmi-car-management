package cn.insectmk.sys.service.impl;

import cn.insectmk.sys.domain.Menu;
import cn.insectmk.sys.domain.MenuVo;
import cn.insectmk.sys.mapper.MenuMapper;
import cn.insectmk.sys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Description 菜单服务接口实现类
 * @Author makun
 * @Date 2023/7/4 16:52
 * @Version 1.0
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> queryAllMenuForList(MenuVo menuVo) {
        return menuMapper.queryAllMenu(menuVo);
    }
}
