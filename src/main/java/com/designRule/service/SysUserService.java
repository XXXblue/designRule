package com.designRule.service;

import com.designRule.pojo.vo.SysuserCustom;
import com.designRule.pojo.vo.SysuserQueryVo;
import com.designRule.result.ExceptionResultInfo;

import java.util.List;

/**
 * @Author: XBlue
 * @Date: Create in 2018/5/2715:24
 * @Description:
 * @Modified By:
 */
public interface SysUserService {
    public int querySysUserCount(SysuserQueryVo sysuserQueryVo) throws Exception;
    public List<SysuserCustom> querySysUser(SysuserQueryVo sysuserQueryVo)throws Exception;
}
