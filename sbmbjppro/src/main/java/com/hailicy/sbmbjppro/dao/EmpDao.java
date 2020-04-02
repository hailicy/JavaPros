package com.hailicy.sbmbjppro.dao;

import com.hailicy.sbmbjppro.entity.Emp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.plugin.Intercepts;

import java.util.List;

/**
 * 创建时间: 2020/4/2 19:31
 * 文件备注:
 * 编写人员:
 */

public interface EmpDao {

    //查询所有的方法
    List<Emp> findAll();

    //保存员工的方法
    void save(Emp emp);

    //删除员工的方法
    void delete(String id);

    //根据id查询员工信息
    Emp findById(String id);

    //更新员工信息
    void update(Emp emp);
}
