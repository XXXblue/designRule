package com.designRule.dao;

import com.designRule.pojo.vo.SysuserCustom;
import com.designRule.pojo.vo.SysuserQueryVo;

import java.util.List;

/**
 * @Author: XBlue
 * @Date: Create in 2018/5/2715:42
 * @Description:
 * @Modified By:
 */
public interface SysuserMapperCustom {

    int querySysuserCount(SysuserQueryVo sysuserQueryVo);

    List<SysuserCustom> querySysuser(SysuserQueryVo sysuserQueryVo);
}
