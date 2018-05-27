package com.designRule.controller;

import com.designRule.dao.SysuserMapper;
import com.designRule.pojo.Sysuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: XBlue
 * @Date: Create in 2018/5/2711:31
 * @Description:
 * @Modified By:
 */
@Controller
public class TestController {
    @Autowired
    private SysuserMapper sysuserMapper;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return sysuserMapper.selectByPrimaryKey(1).getUsername();
    }

    @RequestMapping("/test2")
    public ModelAndView test2(){
        return new ModelAndView("test");
    }
}
