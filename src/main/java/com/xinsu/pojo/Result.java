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
    String message;


    public Result(String key) {
        this.key = key;
    }

    public Result(String key,String message) {
        this.key = key;
        this.message = message;
    }

    public Result(Object object, String key) {
        this.object = object;
        this.key = key;
    }
}

