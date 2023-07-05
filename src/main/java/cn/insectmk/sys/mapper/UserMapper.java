package cn.insectmk.sys.mapper;

import cn.insectmk.sys.domain.Role;
import cn.insectmk.sys.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description dao层接口UserMapper
 * @Author makun
 * @Date 2023/6/27 19:43
 * @Version 1.0
 */
public interface UserMapper {
    List<Role> queryRolesByPrimaryKey(Integer userid);

    /**
     * 保存用户和角色的关系
     * @param userid
     * @param rid
     */
    void insertUserRole(@Param("uid") Integer userid, @Param("rid") Integer rid);

    int deleteByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int insertSelective(User record);

    List<User> queryAllUser(User user);
    /*
     *登录
     * */
    User login(User user);

    User queryByPrimaryKey(Integer userid);
}
