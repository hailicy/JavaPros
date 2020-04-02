package com.hailicy.sbmbjppro;

import com.hailicy.sbmbjppro.dao.EmpDao;
import com.hailicy.sbmbjppro.dao.UserDao;
import com.hailicy.sbmbjppro.entity.Emp;
import com.hailicy.sbmbjppro.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbmbjpproApplicationTests {


    @Autowired
    private UserDao userDao;

    @Autowired
    private EmpDao empDao;

    @Test
    public void contextLoads() {
    }


    @Test
    public void testSave1(){
        userDao.save(new User(UUID.randomUUID().toString(),"xiao42chen","真实42姓名","123564","男"));

    }

    @Test
    public void testFindAll(){
        List<Emp> all = empDao.findAll();
        if(all!=null){
            System.out.println("已找到！");
            for (Emp emp : all) {
                System.out.println(emp);
            }
        }else {
            System.out.println("无员工！");
        }

    }

    @Test//保存员工
    public void testSave(){
        empDao.save(new Emp(UUID.randomUUID().toString(),"插入的e",22225.2,45));
    }

}
