package com.schj.vo;
/**
 * ��ҳ����
 */
public class PageRequest {
    /**
     * ��ǰҳ��
     */
    private int pageNum;
    /**
     * ÿҳ����
     */
    private int pageSize;
    
    public int getPageNum() {
        return pageNum;
    }
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}

