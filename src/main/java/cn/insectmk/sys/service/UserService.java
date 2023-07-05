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
     * 保存用户和角色的关系
     * @param userVo
     */
    void saveUserRole(UserVo userVo);

    /**
     * 加载用户管理分配角色的数据
     * @param userid
     * @return
     */
    DataGridView queryUserRole(Integer userid);

    /**
     * 重置密码
     * @param userid
     */
    void resetUserPwd(Integer userid);

    /**
     * 批量删除用户
     * @param ids
     */
    void deleteBatchUser(Integer[] ids);

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
