package cn.insectmk.sys.mapper;

import cn.insectmk.sys.domain.User;

import java.util.List;

/**
 * @Description dao层接口UserMapper
 * @Author makun
 * @Date 2023/6/27 19:43
 * @Version 1.0
 */
public interface UserMapper {
    int updateByPrimaryKeySelective(User record);

    int insertSelective(User record);

    List<User> queryAllUser(User user);
    /*
     *登录
     * */
    User login(User user);
}
