package com.designRule.utils;

import com.designRule.dao.SysuserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 药品目录 导入接口
 * @author Thinkpad
 *
 */
public class HxlsOptRowsInterfaceImpl implements HxlsOptRowsInterface {
	@Autowired
	private SysuserMapper sysuserMapper;

	@Override
	public String optRows(int sheetIndex, int curRow, List<String> rowlist)
			throws Exception {
		System.out.println(sysuserMapper.selectByPrimaryKey(1).getUsername());
		System.out.println("===================================");
		//获取解析到的一行数据
		System.out.println(rowlist.get(0));
//		模拟导入失败，这个Hxls工具类只要返回不是success就属于导入失败，否则就是导入成功
		if(rowlist.get(1).equals("青霉素")){
//			记录导入失败的原因，返回的就是原因
			return "导入失败名字不能为亲霉素";
		}
		//校验数据合法性
		//.......
		
		System.out.println(rowlist.get(1));
		System.out.println(rowlist.get(2));
		
		//封装到po类
		
		//调用mapper插入数据库
		
		//插入数据库
		//System.out.println("sheetIndex="+sheetIndex+"curRow="+curRow+rowlist);
		return "success";
	}
	
}
