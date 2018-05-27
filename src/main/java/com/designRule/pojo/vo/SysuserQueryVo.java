package com.designRule.pojo.vo;

import com.designRule.pojo.Sysuser;
import com.designRule.utils.PageQuery;

/**
 * @Author: XBlue
 * @Date: Create in 2018/5/2715:20
 * @Description:
 * @Modified By:
 */
//多表扩展的包装类，查询或者提交用，扩展性强，看下面可以增加更多的扩展条件
public class SysuserQueryVo {
    //查询条件
    private SysuserCustom sysuserCustom;

    //更多的查询条件可以扩展进来，简单的说就是不包括在sysuser表里面的查询条件

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
