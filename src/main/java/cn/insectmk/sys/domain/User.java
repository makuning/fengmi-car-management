package cn.insectmk.sys.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description User类
 * @Author makun
 * @Date 2023/6/27 19:36
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //用户id
    private Integer userid;
    //登录名称
    private String loginname;
    //身份证号码
    private String identity;
    //真实姓名
    private String realname;
    //性别
    private Integer sex;
    //地址
    private String address;
    //电话
    private String phone;
    //密码
    private String pwd;
    //职位
    private String position;
    //用户类型
    private Integer type;
    //是否可用
    private Integer available;

    public Integer getUserid() {
        return userid;
    }
}
