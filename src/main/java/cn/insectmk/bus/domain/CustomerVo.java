package cn.insectmk.bus.domain;

import cn.insectmk.bus.domain.Customer;

import java.util.Arrays;

/**
 * @Description 客户视图对象
 * @Author makun
 * @Date 2023/6/28 16:53
 * @Version 1.0
 */
public class CustomerVo extends Customer {
    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;

    //接受多个id
    private String [] ids;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "CustomerVo{" +
                "page=" + page +
                ", limit=" + limit +
                ", ids=" + Arrays.toString(ids) +
                '}';
    }
}
