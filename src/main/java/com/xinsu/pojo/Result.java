package com.xinsu.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yeyike
 * @date 2020/7/15 - 20:03
 */
@Data
@NoArgsConstructor
public class Result {
    Object object;
    String key;
    String[] usage;


    public Result(String key) {
        this.key = key;
    }

    public Result(String key,String[] value) {
        this.key = key;
        this.usage = value;
    }

    public Result(Object object, String key) {
        this.object = object;
        this.key = key;
    }
}

