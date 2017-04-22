package com.qbian.common.dto;

/**
 * 分页查询时的查询对象
 * Created by qbian on 17/4/22.
 */
public class PageInfoDto {

    /**
     * 当前页
     */
    private int pageNo;

    /**
     * 当前页数
     */
    private int pageSize;

    /**
     * 总页数
     */
    private int totalSize;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }
}
