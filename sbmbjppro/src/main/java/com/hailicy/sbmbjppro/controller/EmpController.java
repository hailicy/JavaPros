package com.hailicy.sbmbjppro.controller;

import com.hailicy.sbmbjppro.entity.Emp;
import com.hailicy.sbmbjppro.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 创建时间: 2020/4/2 19:26
 * 文件备注:
 * 编写人员:
 */

@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    //保存员工
    @PostMapping("/save")
    public String save(Emp emp){
        empService.save(emp);
        return "redirect:/emp/findAll";
    }

    //查询所有
    @GetMapping("/findAll")
    public String findAll(Model model){
        List<Emp> emps = empService.findAll();
        model.addAttribute("emps",emps);
        return "ems/emplist";
    }

    //删除用户根据id
    @GetMapping("/delete")
    public String delete(String id){
        empService.delete(id);


        return "redirect:/emp/findAll";
    }

    //根据id查询
    @GetMapping("/findOne")
    public String findOne(String id,Model model){
        Emp emp = empService.findById(id);
        model.addAttribute("emp",emp);
        return "/ems/updateEmp";
    }

    //修改更新
    @PostMapping("/update")
    public String update(Emp emp){
        empService.update(emp);
        return "redirect:/emp/findAll";

    }



}
