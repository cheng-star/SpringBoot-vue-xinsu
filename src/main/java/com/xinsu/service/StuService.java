package com.xinsu.service;

import com.xinsu.pojo.Stu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yeyike
 * @date 2020/7/15 - 19:17
 */
@Mapper
@Repository
public interface StuService {

    int updateStu(Stu stu);
    int deleteStu(int ID);
    Stu queryStuByID(int ID);
}
