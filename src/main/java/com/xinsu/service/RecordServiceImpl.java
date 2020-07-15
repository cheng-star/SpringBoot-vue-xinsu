package com.xinsu.service;

import com.xinsu.mapper.RecordMapper;
import com.xinsu.pojo.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yeyike
 * @date 2020/7/15 - 19:45
 */
@Service
public class RecordServiceImpl implements RecordService{

    @Autowired
    RecordMapper recordMapper;

    @Override
    public int deleteRecords(int serial) {
        return recordMapper.deleteRecords(serial);
    }

    @Override
    public int addRecord(Record record) {
        return recordMapper.addRecord(record);
    }
}
