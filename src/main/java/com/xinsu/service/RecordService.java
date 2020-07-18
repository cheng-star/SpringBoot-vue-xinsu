package com.xinsu.service;

import com.xinsu.pojo.Record;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yeyike
 * @date 2020/7/15 - 19:46
 */
@Mapper
@Repository
public interface RecordService {

    List<Record> queryRecordByID(int ID);
    int deleteRecords(int ID);
    int addRecord(Record record);
}
