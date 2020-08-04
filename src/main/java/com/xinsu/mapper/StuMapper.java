package com.xinsu.mapper;

import com.xinsu.pojo.Stu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yeyike
 * @date 2020/7/11 - 0:08
 */
@Mapper
@Repository
public interface StuMapper {

    List<Stu> queryStuList();

    int addStu(Stu stu);

    Stu queryStuByID(Integer ID);

    int updateStu(@Param("ID") Integer ID, @Param("balance") Integer balance);

    int deleteStu(Integer ID);
}
