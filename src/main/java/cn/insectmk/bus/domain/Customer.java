package cn.insectmk.bus.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description 客户实体对象
 * @Author makun
 * @Date 2023/6/28 16:52
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String identity;

    private String custname;

    private Integer sex;

    private String address;

    private String phone;

    private String career;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createtime;
}
