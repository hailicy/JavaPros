package com.hailicy.shiro01.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.springframework.stereotype.Repository;

/**
 * 创建时间: 2020/5/3 14:02
 * 文件备注:
 * 编写人员: 杨伯益
 */

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Repository
@TableName("User")
public class User {

    Integer id;
    String username;
    String password;
    String perms;
}
