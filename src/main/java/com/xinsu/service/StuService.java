package com.xinsu.service;

import com.xinsu.pojo.Stu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yeyike
 * @date 2020/7/15 - 19:17
 */
@Mapper
@Repository
public interface StuService {

    int updateStu(@Param("ID") Integer ID, @Param("balance") Integer balance);
    int deleteStu(Integer ID);
    Stu queryStuByID(Integer ID);
    List<Stu> queryStuList();
    int addStu(Stu stu);
}
