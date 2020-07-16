package com.xinsu.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author yeyike
 * @date 2020/7/10 - 19:28
 */
@Data
@NoArgsConstructor
public class Record {
    private int ID;
    private String detail;
    private Date timestamp;
    private int serial;

    public Record(String detail,int ID){
        this.detail = detail;
        this.ID = ID;
        timestamp = new Date();
    }
}
