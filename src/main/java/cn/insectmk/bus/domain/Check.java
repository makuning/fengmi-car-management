package cn.insectmk.bus.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

/**
 * @Description 检查单，入库表实体
 * @Author makun
 * @Date 2023/7/4 15:30
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Check {
    private String checkid;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date checkdate;
    private String checkdesc;
    private String problem;
    private Double paymoney;
    private String opername;
    private String rentid;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createtime;
}
