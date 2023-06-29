package cn.insectmk.sys.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @Description Account持久层访问
 * @Author makun
 * @Date 2023/6/26 18:47
 * @Version 1.0
 */
public interface AccountMapper {
    //转入钱
    public void transferIn(@Param("name") String name, @Param("money")double money);
    //转出钱
    public void transferOut(@Param("name") String name, @Param("money")double money);
}
