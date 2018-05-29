package com.designRule.controller;


import com.designRule.pojo.vo.SysuserCustom;
import com.designRule.pojo.vo.SysuserQueryVo;
import com.designRule.result.ExceptionResultInfo;
import com.designRule.result.ResultInfo;
import com.designRule.service.SysUserService;
import com.designRule.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    @Autowired
    private HxlsOptRowsInterface hxlsOptRowsInterface;

    @RequestMapping("/list")
    public ModelAndView list() throws Exception {
//        页面异常测试通过
//        模拟可预知异常
//        ResultInfo resultInfo = new ResultInfo();
//        resultInfo.setMessageCode(ResultInfo.TYPE_RESULT_FAIL);
//        测试国际化
//        resultInfo.setMessage(ResourcesUtil.getValue("messages","101"));
//        if(1==1){
//            throw new ExceptionResultInfo(resultInfo);
//        }


//        这个resultUtil就是把上面那一大堆代码封装成一句话，result是系统级别的，它应该还包括submitInfo的结果信息的封装
//        ResultUtil.throwExcepion(ResultUtil.createFail("messages",101,null));


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

//    excel导出
    @RequestMapping("/exportYpxxSubmit")
    @ResponseBody
    public String exportYpxxSubmit() throws Exception {
        //上面这个可以带XXXQueryVo参数，导出指定条件的数据，导出的文件会在你的虚拟文件目录生成文件，用tomcat访问虚拟文件目录的web路径即可直接下载文件

        //==============导出文件存放的路径，并且是虚拟目录指向的路径，这个是你文件目录，如果是linux环境下就要换成linux的目录
        //==============这里还有要改进的地方就是这个filePath和后面的webFilePath要单独抽成一张系统运行参数表，可供用户修改配置
        String filePath = "d:/upload/linshi/";
        //导出文件的前缀
        String filePrefix="ypxx";
        //-1表示关闭自动刷新，手动控制写磁盘的时机，其它数据表示多少数据在内存保存，超过的则写入磁盘
        int flushRows=100;
        //定义导出数据的title
        List<String> fieldNames=new ArrayList<String>();
        fieldNames.add("流-水-号");
        fieldNames.add("通-用-名");
        fieldNames.add("价-格");
        //告诉导出类数据list中对象的属性，让ExcelExportSXXSSF通过反射获取对象的值
        List<String> fieldCodes=new ArrayList<String>();
        fieldCodes.add("bm");//药品流水号
        fieldCodes.add("mc");//通用名
        fieldCodes.add("price");//价格
        //注意：fieldCodes和fieldNames个数必须相同且属性和title顺序一一对应，这样title和内容才一一对应
        //开始导出，执行一些workbook及sheet等对象的初始创建
        ExcelExportSXXSSF excelExportSXXSSF = ExcelExportSXXSSF.start(filePath, "/upload/", filePrefix, fieldNames, fieldCodes, flushRows);
        //准备导出的数据，将数据存入list，且list中对象的字段名称必须是刚才传入ExcelExportSXXSSF的名称
        //现在导出的数据先不从数据库取出，模拟导出看看能否成功
        List<Ypxx> list = new ArrayList<Ypxx>();
        Ypxx ypxx1 = new Ypxx("001", "青霉素", 5);
        Ypxx ypxx2 = new Ypxx("002", "感冒胶囊", 2.5f);
        list.add(ypxx1);
        list.add(ypxx2);
        //执行导出
        excelExportSXXSSF.writeDatasByObject(list);
        //输出文件，返回下载文件的http地址
        String webpath = excelExportSXXSSF.exportFile();
        System.out.println(webpath);
        //返回这个webpath可以填充到页面的a标签中提供给页面点击下载，
        return webpath;
    }

//    excel导入
    @RequestMapping("/upload")
    public ModelAndView upload() throws Exception {
        return new ModelAndView("upload");
    }

    @RequestMapping("/uploadfile")
    @ResponseBody
    public String uploadfile(@RequestParam MultipartFile[] myfiles, HttpServletRequest request) throws IOException {
        for(MultipartFile multipartFile:myfiles){
            if(!multipartFile.isEmpty()){
                String originalFileName = multipartFile.getOriginalFilename();
                //写入磁盘文件
                File file = new File("D:/upload/linshi/"+ UUIDBuild.getUUID()+originalFileName.substring(originalFileName.lastIndexOf(".")));
                //文件不存在则创建
                if(!file.exists()){
                    file.mkdirs();
                }
                //写入磁盘
                multipartFile.transferTo(file);
                String absolutePath = file.getAbsolutePath();
                HxlsRead xls2csv = null;
                try {
                    //第一个参数就是导入的文件
                    //第二个参数就是导入文件中哪个sheet
                    //第三个参数导入接口的实现类对象,这个hxlsOptRowsInterface的bean是注入进来的，它的实现类已经在xml文件进行了配置了。
                    xls2csv = new HxlsRead(absolutePath,0,hxlsOptRowsInterface);
                    xls2csv.process();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                long success = xls2csv.getOptRows_success();
                long fail = xls2csv.getOptRows_failure();
                System.out.println(success+"=============================");
                System.out.println(fail+"===============================");
            }
        }
        return "success";
    }
}
