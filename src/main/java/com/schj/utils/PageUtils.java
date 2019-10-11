package com.schj.utils;

import com.github.pagehelper.PageInfo;
import com.schj.vo.PageRequest;
import com.schj.vo.PageResult;

public class PageUtils {

    /**
     * ����ҳ��Ϣ��װ��ͳһ�Ľӿ�
     * @param pageRequest 
     * @param page
     * @return
     */
    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}