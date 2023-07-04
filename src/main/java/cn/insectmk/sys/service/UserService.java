package cn.insectmk.sys.service;

import cn.insectmk.sys.domain.DataGridView;
import cn.insectmk.sys.domain.User;
import cn.insectmk.sys.domain.UserVo;

/**
 * @Description 用户业务层接口
 * @Author makun
 * @Date 2023/6/27 19:41
 * @Version 1.0
 */
public interface UserService {
    /**
     * 根据id删除用户
     * @param userid
     */
    void deleteUser(Integer userid);

    /**
     * 修改用户
     * @param userVo
     */
    void updateUser(UserVo userVo);

    /**
     * 添加用户
     * @param userVo
     */
    void addUser(UserVo userVo);

    /**
     * 查询所有用户
     * @param userVo
     * @return
     */
    DataGridView queryAllUser(UserVo userVo);

    /**
     * 用户登录
     * @param userVo
     * @return
     */
    User login(UserVo userVo);
}
