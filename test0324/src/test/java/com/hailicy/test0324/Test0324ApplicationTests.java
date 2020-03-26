package com.hailicy.test0324;

import com.hailicy.test0324.pojo.Dog;
import com.hailicy.test0324.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//单元测试
@SpringBootTest
class Test0324ApplicationTests {

    @Autowired
    private Person person;


    @Test
    void contextLoads() {
        System.out.println(person);



    }

}
