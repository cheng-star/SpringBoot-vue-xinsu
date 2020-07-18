package com.xinsu.controller;

import com.xinsu.pojo.Record;
import com.xinsu.service.RecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yeyike
 * @date 2020/7/17 - 15:42
 */
@RestController
public class RecordController {
    @Autowired
    RecordServiceImpl recordService;

    @RequestMapping("view/queryRecordByID")
    public List<Record> queryRecordByID(int ID){
        return recordService.queryRecordByID(ID);
    }
}
