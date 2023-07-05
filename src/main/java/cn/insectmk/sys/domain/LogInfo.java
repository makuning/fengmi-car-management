package cn.insectmk.sys.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * @Description 日志信息实体
 * @Author makun
 * @Date 2023/7/5 13:09
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogInfo {
    private Integer id;
    private String loginname;
    private String loginip;
    //转换到页面上的时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date logintime;
}
