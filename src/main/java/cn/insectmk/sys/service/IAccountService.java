package cn.insectmk.sys.service;

/**
 * @Description 账户服务接口
 * @Author makun
 * @Date 2023/6/26 18:50
 * @Version 1.0
 */
public interface IAccountService {
    //转账
    public int updateTransfer(String inName, String outName , double money);
}
