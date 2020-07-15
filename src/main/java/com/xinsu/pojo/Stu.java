package com.xinsu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yeyike
 * @date 2020/7/10 - 19:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stu {

    private int ID;
    private String name;
    private String clazz;
    private String mail;
    private int balance;
}
