package cn.insectmk.sys.service;

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
     * 用户登录
     * @param userVo
     * @return
     */
    User login(UserVo userVo);
}
