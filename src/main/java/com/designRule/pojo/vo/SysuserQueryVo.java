package com.designRule.pojo.vo;

import com.designRule.pojo.Sysuser;
import com.designRule.utils.PageQuery;

/**
 * @Author: XBlue
 * @Date: Create in 2018/5/2715:20
 * @Description:
 * @Modified By:
 */
public class SysuserQueryVo {
    //查询条件
    private SysuserCustom sysuserCustom;

    //更多的查询条件

    //分页条件
    private PageQuery pageQuery;

    public SysuserCustom getSysuserCustom() {
        return sysuserCustom;
    }

    public void setSysuserCustom(SysuserCustom sysuserCustom) {
        this.sysuserCustom = sysuserCustom;
    }

    public PageQuery getPageQuery() {
        return pageQuery;
    }

    public void setPageQuery(PageQuery pageQuery) {
        this.pageQuery = pageQuery;
    }
}
