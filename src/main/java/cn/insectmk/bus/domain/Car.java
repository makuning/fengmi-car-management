package cn.insectmk.bus.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description 车辆实体类
 * @Author makun
 * @Date 2023/6/29 14:56
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String carnumber;

    private String cartype;

    private String color;

    private Double price;

    private Double rentprice;

    private Double deposit;

    private Integer isrenting;

    private String description;

    private String carimg;

    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss", timezone = "GTM+8")
    private Date createtime;
}
