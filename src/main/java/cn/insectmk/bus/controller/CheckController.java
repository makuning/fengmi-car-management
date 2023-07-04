package cn.insectmk.bus.controller;

import cn.insectmk.bus.domain.Rent;
import cn.insectmk.bus.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 入库管理
 * @Author makun
 * @Date 2023/7/4 15:29
 * @Version 1.0
 */
@RestController
@RequestMapping("check")
public class CheckController {

    @Autowired
    private RentService rentService;


    @RequestMapping("checkRentExist")
    public Rent checkRentExist(String rentid){
        //出租单号不存在，返回一个null，出租单号存在，返回一个rent对象
        Rent rent = rentService.queryRentByRentId(rentid);
        return rent;
    }
}
