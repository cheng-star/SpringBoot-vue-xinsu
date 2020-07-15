package com.xinsu.service;

import com.xinsu.pojo.Record;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yeyike
 * @date 2020/7/15 - 19:46
 */
@Mapper
@Repository
public interface RecordService {

    int deleteRecords(int serial);
    int addRecord(Record record);
}
