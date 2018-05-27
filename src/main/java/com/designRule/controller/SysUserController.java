package com.designRule.controller;

import com.alibaba.druid.sql.PagerUtils;
import com.designRule.pojo.Sysuser;
import com.designRule.pojo.vo.SysuserCustom;
import com.designRule.pojo.vo.SysuserQueryVo;
import com.designRule.result.ExceptionResultInfo;
import com.designRule.result.ResultInfo;
import com.designRule.service.SysUserService;
import com.designRule.utils.PageQuery;
import com.designRule.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
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
    public ModelAndView list() throws Exception {
//        页面异常测试通过
//        模拟可预知异常
//        ResultInfo resultInfo = new ResultInfo();
//        resultInfo.setMessageCode(ResultInfo.TYPE_RESULT_FAIL);
//        resultInfo.setMessage("我觉得不行");
//        if(1==1){
//            throw new ExceptionResultInfo(resultInfo);
//        }
//        模拟未知错误异常
//        int a = 1/0;
        return new ModelAndView("list");
    }

    @RequestMapping("/querySysuser.json")
    @ResponseBody
    public PageResult querySysuser(SysuserQueryVo sysuserQueryVo,int page, int limit)throws Exception{
//        json测试异常成功
//        模拟可预知异常
//        ResultInfo resultInfo = new ResultInfo();
//        resultInfo.setMessageCode(ResultInfo.TYPE_RESULT_FAIL);
//        resultInfo.setMessage("我觉得不行");
//        if(1==1){
//            throw new ExceptionResultInfo(resultInfo);
//        }
//        模拟未知异常
//        int a = 1/0;

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
