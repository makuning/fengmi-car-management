package cn.insectmk.sys.controller;

import cn.insectmk.sys.service.IAccountService;
import cn.insectmk.sys.utils.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 系统控制层
 * @Author makun
 * @Date 2023/6/26 18:55
 * @Version 1.0
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService service;

    @RequestMapping("transfer")
    @ResponseBody
    @Transactional
    public ResultObj accountTransfer(String inName, String outName, double money){
        int status = service.updateTransfer(inName, outName, money);
        //如果执行转账成功
        if(status > 0 ){
            return ResultObj.STATUS_TRUE;
        }else{
            return  ResultObj.STATUS_FALSE;
        }
    }
}
