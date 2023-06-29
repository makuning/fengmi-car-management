package cn.insectmk.sys.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description layui数据表格的数据对象
 * @Author makun
 * @Date 2023/6/28 16:51
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataGridView {
    /**
     * 封装layui数据表格的数据对象
     */
    private Integer code=0;
    private String msg="";
    private Long count;
    private Object data;

    public DataGridView(Object data) {
        super();
        this.data = data;
    }

    public DataGridView(Long count, Object data) {
        super();
        this.count = count;
        this.data = data;
    }
}
