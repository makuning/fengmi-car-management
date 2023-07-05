package cn.insectmk.sys.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Description 日志信息视图对象
 * @Author makun
 * @Date 2023/7/5 13:10
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogInfoVo extends LogInfo {
    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;
    /**
     * 扩展表单参数  将前台时间提交到后台
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    //接受多个id
    private Integer [] ids;
}
