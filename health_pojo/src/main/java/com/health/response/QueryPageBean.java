package com.health.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 封装查询条件
 */
@Data
public class QueryPageBean implements Serializable{
    private Integer Page;//页码
    private Integer pageSize;//每页记录数

    public Integer getPage() {
        return Page;
    }

    public void setPage(Integer page) {
        Page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}