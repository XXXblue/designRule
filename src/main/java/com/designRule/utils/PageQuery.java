package com.designRule.utils;

/**
 * @Author: XBlue
 * @Date: Create in 2018/5/2715:12
 * @Description:
 * @Modified By:
 */
public class PageQuery {
    private int page;
    private int limit;
    private int offset;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return (page-1)*limit;
    }
}
