package com.myou.security.models;

import java.io.Serializable;
import java.util.List;

/**
 * @Author myou
 * @Date 2020/8/12  11:36 上午
 */
public class PageInfo implements Serializable {
    private int pageSize = 10;
    private int pageIndex = 1;
    private String sortField;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public int pageNumber() {
        return (this.pageSize - 1) * this.pageIndex;
    }
}
