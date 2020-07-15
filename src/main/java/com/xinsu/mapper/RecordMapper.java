package com.xinsu.mapper;

import com.xinsu.pojo.Record;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yeyike
 * @date 2020/7/11 - 0:07
 */
@Mapper
@Repository
public interface RecordMapper {

    List<Record> queryRecordByID(int ID);
    int addRecord(Record record);
}
