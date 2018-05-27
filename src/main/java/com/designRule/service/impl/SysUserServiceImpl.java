package com.designRule.service.impl;

import com.designRule.dao.SysuserMapperCustom;
import com.designRule.pojo.vo.SysuserCustom;
import com.designRule.pojo.vo.SysuserQueryVo;
import com.designRule.result.ExceptionResultInfo;
import com.designRule.result.ResultInfo;
import com.designRule.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.sun.tools.classfile.Attribute.Exceptions;

/**
 * @Author: XBlue
 * @Date: Create in 2018/5/2715:37
 * @Description:
 * @Modified By:
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysuserMapperCustom sysuserMapperCustom;

    @Override
    public int querySysUserCount(SysuserQueryVo sysuserQueryVo) throws Exception {
        return sysuserMapperCustom.querySysuserCount(sysuserQueryVo);
    }

    @Override
    public List<SysuserCustom> querySysUser(SysuserQueryVo sysuserQueryVo) throws Exception{
        return sysuserMapperCustom.querySysuser(sysuserQueryVo);
    }
}
