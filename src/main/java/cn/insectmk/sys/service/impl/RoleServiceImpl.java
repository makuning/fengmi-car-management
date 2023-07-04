package cn.insectmk.sys.service.impl;

import cn.insectmk.sys.domain.DataGridView;
import cn.insectmk.sys.domain.Role;
import cn.insectmk.sys.domain.RoleVo;
import cn.insectmk.sys.mapper.RoleMapper;
import cn.insectmk.sys.service.RoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Description 角色模块服务接口实现类
 * @Author makun
 * @Date 2023/7/4 19:17
 * @Version 1.0
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public DataGridView queryAllRole(RoleVo roleVo) {
        Page<Object> page = PageHelper.startPage(roleVo.getPage(),roleVo.getLimit());
        List<Role> data = this.roleMapper.queryAllRole(roleVo);
        return new DataGridView(page.getTotal(),data);
    }
}