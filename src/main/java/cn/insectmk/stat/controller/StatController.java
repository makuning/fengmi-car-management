package cn.insectmk.stat.controller;

/**
 * @Description 基础功能控制器
 * @Author makun
 * @Date 2023/7/4 14:52
 * @Version 1.0
 */

import cn.insectmk.bus.domain.Customer;
import cn.insectmk.bus.domain.Rent;
import cn.insectmk.bus.service.CustomerService;
import cn.insectmk.bus.service.RentService;
import cn.insectmk.sys.utils.ExportRentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 统计分析
 */
@RequestMapping("stat")
@Controller
public class StatController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RentService rentService;


    /**
     * 导出出租单数据
     * @param rentid
     */
    @RequestMapping("exportRent")
    public ResponseEntity<Object> exportRent(String rentid){
        //根据出租单号查询出租单信息
        Rent rent = rentService.queryRentByRentId(rentid);
        //根据身份证号查询客户信息
        Customer customer = customerService.queryCustomerByIdentity(rent.getIdentity());
        String fileName=customer.getCustname()+"-的出租单.xls";
        String sheetName=customer.getCustname()+"出租单";
        ByteArrayOutputStream bos = ExportRentUtils.exportRent(rent,customer,sheetName);

        try {
            //处理文件名乱码
            fileName= URLEncoder.encode(fileName,"UTF-8");
            //创建 封装响应头信息的对象
            HttpHeaders headers = new HttpHeaders();
            //封装响应内容类型(APPLICATION_OCTET_STREAM 响应的内容不限定)
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            //设置下载的文件的名称
            headers.setContentDispositionFormData("attachment",fileName);
            return new ResponseEntity<Object>(bos.toByteArray(),headers, HttpStatus.CREATED);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
