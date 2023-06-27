package cn.insectmk.sys.service.impl;

import cn.insectmk.sys.domain.User;
import cn.insectmk.sys.domain.UserVo;
import cn.insectmk.sys.mapper.UserMapper;
import cn.insectmk.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

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


    @Override
    public User login(UserVo userVo) {
        //明文
        //生成密文
        String pwd = DigestUtils.md5DigestAsHex(userVo.getPwd().getBytes());
        userVo.setPwd(pwd);
        return userMapper.login(userVo);
    }
}
