package com.xinsu.mapper;

import com.xinsu.pojo.Operaters;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yeyike
 * @date 2020/7/11 - 10:20
 */
@Mapper
@Repository
public interface OperatersMapper {

    List<Operaters> queryOperatersList();
}
