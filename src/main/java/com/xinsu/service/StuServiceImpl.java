package com.xinsu.service;

import com.xinsu.mapper.StuMapper;
import com.xinsu.pojo.Stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yeyike
 * @date 2020/7/15 - 19:31
 */
@Service
public class StuServiceImpl implements StuService{

    @Autowired
    StuMapper stuMapper;

    @Override
    public int updateStu(Integer ID,Integer balance) {
        return stuMapper.updateStu(ID,balance);
    }

    @Override
    public int deleteStu(Integer ID) {
        return stuMapper.deleteStu(ID);
    }

    @Override
    public Stu queryStuByID(Integer ID) {
        return stuMapper.queryStuByID(ID);
    }

    @Override
    public List<Stu> queryStuList() {
        return stuMapper.queryStuList();
    }

    @Override
    public int addStu(Stu stu) {
        return stuMapper.addStu(stu);
    }
}
