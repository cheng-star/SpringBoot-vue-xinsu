package com.xinsu.service;

import com.xinsu.mapper.OperatersMapper;
import com.xinsu.pojo.Operaters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yeyike
 * @date 2020/7/11 - 10:51
 */
@Service
public class OPeratersServiceImpl implements OperatersService{

    @Autowired
    OperatersMapper operatersMapper;

    @Override
    public List<Operaters> queryOperatersList() {
        return operatersMapper.queryOperatersList();
    }
}
