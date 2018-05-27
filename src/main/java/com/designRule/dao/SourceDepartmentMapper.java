package com.designRule.dao;

import com.designRule.pojo.SourceDepartment;

public interface SourceDepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SourceDepartment record);

    int insertSelective(SourceDepartment record);

    SourceDepartment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SourceDepartment record);

    int updateByPrimaryKey(SourceDepartment record);
}