package cn.insectmk.sys.service.impl;

import cn.insectmk.sys.domain.DataGridView;
import cn.insectmk.sys.domain.User;
import cn.insectmk.sys.domain.UserVo;
import cn.insectmk.sys.mapper.RoleMapper;
import cn.insectmk.sys.mapper.UserMapper;
import cn.insectmk.sys.service.UserService;
import cn.insectmk.sys.utils.SysConstant;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import java.util.List;

/**
 * @Description 业务层实现类
 * @Author makun
 * @Date 2023/6/27 19:42
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    /**
     * 重置用户的密码
     * @param userid
     */
    @Override
    public void resetUserPwd(Integer userid) {
        User user = new User();
        user.setUserid(userid);
        //设置默认密码
        user.setPwd(DigestUtils.md5DigestAsHex(SysConstant.USER_DEFAULT_PWD.getBytes()));
        //设置完成后更新
        this.userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void deleteBatchUser(Integer[] ids) {
        for (Integer uid:ids) {
            this.deleteUser(uid);
        }
    }

    /**
     * 删除用户
     * @param userid
     */
    @Override
    public void deleteUser(Integer userid) {
        //先删除用户
        this.userMapper.deleteByPrimaryKey(userid);
        //根据用户id删除sys_role_user
        this.roleMapper.deleteRoleUserByUid(userid);
    }

    /**
     * 修改用户
     * @param userVo
     */
    @Override
    public void updateUser(UserVo userVo) {
        this.userMapper.updateByPrimaryKeySelective(userVo);
    }

    /**
     * 添加用户
     * @param userVo
     */
    @Override
    public void addUser(UserVo userVo) {
        //设置默认密码
        userVo.setPwd(DigestUtils.md5DigestAsHex(SysConstant.USER_DEFAULT_PWD.getBytes()));
        //设置用户类型都是普通用户type=2
        userVo.setType(SysConstant.USER_TYPE_NORMAL);
        this.userMapper.insertSelective(userVo);
    }

    /**
     * 查询所有用户
     * @param userVo
     * @return
     */
    @Override
    public DataGridView queryAllUser(UserVo userVo) {
        Page<Object> page = PageHelper.startPage(userVo.getPage(), userVo.getLimit());
        List<User> data = this.userMapper.queryAllUser(userVo);
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public User login(UserVo userVo) {
        //明文
        //生成密文
        String pwd = DigestUtils.md5DigestAsHex(userVo.getPwd().getBytes());
        userVo.setPwd(pwd);
        return userMapper.login(userVo);
    }
}
