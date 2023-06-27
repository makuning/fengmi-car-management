package cn.insectmk.sys.mapper;

import cn.insectmk.sys.domain.User;

/**
 * @Description dao层接口UserMapper
 * @Author makun
 * @Date 2023/6/27 19:43
 * @Version 1.0
 */
public interface UserMapper {
    /*
     *登录
     * */
    User login(User user);
}
