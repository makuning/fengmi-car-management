package cn.insectmk.sys.service.impl;

import cn.insectmk.sys.mapper.AccountMapper;
import cn.insectmk.sys.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description 账户服务类实现
 * @Author makun
 * @Date 2023/6/26 18:50
 * @Version 1.0
 */
@Service
@Transactional  //事务控制
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private AccountMapper mapper;

    @Override
    public int updateTransfer(String inName, String outName, double money) {
        try{
            //调用转入
            mapper.transferIn(inName,money);
            //调用转出
            mapper.transferOut(outName,money);
            return 0;
        }catch (Exception e){
            System.out.println(e);
            return 1;
        }
    }
}
