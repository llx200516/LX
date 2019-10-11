package com.schj.vo;

import java.util.List;
/**
 * ��ҳ���ؽ��
 */
public class PageResult {
    /**
     * ��ǰҳ��
     */
    private int pageNum;
    /**
     * ÿҳ����
     */
    private int pageSize;
    /**
     * ��¼����
     */
    private long totalSize;
    /**
     * ҳ������
     */
    private int totalPages;
    /**
     * ����ģ��
     */
    private List<?> content;
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
    public long getTotalSize() {
        return totalSize;
    }
    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }
    public int getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    public List<?> getContent() {
        return content;
    }
    public void setContent(List<?> content) {
        this.content = content;
    }
}
