package com.xinsu.pojo;

/**
 * @author yeyike
 * @date 2020/7/15 - 20:03
 */
public class Result {
    String key;
    String[] usage;

    public Result(String key) {
        this.key = key;
    }

    public Result(String key,String[] value) {
        this.key = key;
        this.usage = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String[] getUsage() {
        return usage;
    }

    public void setUsage(String[] usage) {
        this.usage = usage;
    }
}

