package com.hailicy.sbmbjppro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 创建时间: 2020/4/2 19:28
 * 文件备注:
 * 编写人员:
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Emp {

    private String id;
    private String name;
    private Double salary;
    private Integer age;
}
