package com.hailicy.sbmbjppro.service;

import com.hailicy.sbmbjppro.dao.EmpDao;
import com.hailicy.sbmbjppro.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * 创建时间: 2020/4/2 20:32
 * 文件备注:
 * 编写人员:
 */

@Service
@Transactional
public class EmpServiceImpl implements EmpService {



    @Autowired
    private EmpDao empDao;


    @Override
    public void update(Emp emp) {
        empDao.update(emp);
    }


    @Override
    public Emp findById(String id) {
        return empDao.findById(id);
    }

    @Override
    public void delete(String id) {
        empDao.delete(id);
    }



    @Override
    public void save(Emp emp) {
        emp.setId(UUID.randomUUID().toString());
        empDao.save(emp);
    }

    @Override
    public List<Emp> findAll() {
        return empDao.findAll();
    }
}