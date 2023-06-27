package cn.insectmk.sys.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

class UserServiceImplTest {
    @Test
    void login() {
        String pwd = DigestUtils.md5DigestAsHex("123456".getBytes());
        System.out.println(pwd);
    }
}