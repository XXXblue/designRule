package com.designRule.dao;

import com.designRule.pojo.DesignDepartment;

public interface DesignDepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DesignDepartment record);

    int insertSelective(DesignDepartment record);

    DesignDepartment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DesignDepartment record);

    int updateByPrimaryKey(DesignDepartment record);
}