package com.designRule.pojo.vo;

import com.designRule.pojo.Sysuser;

/**
 * @Author: XBlue
 * @Date: Create in 2018/5/2715:19
 * @Description:
 * @Modified By:
 */
//多表扩展的结果返回类型
public class SysuserCustom extends Sysuser {
    private String mc;

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }
}
