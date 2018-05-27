package com.designRule.controller;

import com.alibaba.druid.sql.PagerUtils;
import com.designRule.pojo.Sysuser;
import com.designRule.pojo.vo.SysuserCustom;
import com.designRule.pojo.vo.SysuserQueryVo;
import com.designRule.service.SysUserService;
import com.designRule.utils.PageQuery;
import com.designRule.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: XBlue
 * @Date: Create in 2018/5/2715:04
 * @Description:
 * @Modified By:
 */
@Controller
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/list")
    public ModelAndView list(){
        return new ModelAndView("list");
    }

    @RequestMapping("/querySysuser.json")
    @ResponseBody
    public PageResult querySysuser(SysuserQueryVo sysuserQueryVo,int page, int limit){
        //填充分页条件
        PageQuery pageQuery = new PageQuery();
        pageQuery.setPage(page);
        pageQuery.setLimit(limit);
        sysuserQueryVo.setPageQuery(pageQuery);
        //查询条件为空是给个默认值
        if(sysuserQueryVo == null){
            sysuserQueryVo = new SysuserQueryVo();
        }
        int total = sysUserService.querySysUserCount(sysuserQueryVo);
        List<SysuserCustom> rows = sysUserService.querySysUser(sysuserQueryVo);
        //封装返回结果
        PageResult pageResult = new PageResult();
        pageResult.setCount(total);
        pageResult.setData(rows);
        pageResult.setMsg("");
        pageResult.setCode(0);
        return pageResult;
    }
}
