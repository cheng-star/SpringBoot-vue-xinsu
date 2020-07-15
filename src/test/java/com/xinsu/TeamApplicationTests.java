package com.xinsu;

import com.xinsu.mapper.OperatersMapper;
import com.xinsu.pojo.Operaters;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeamApplicationTests {
    @Autowired
    private OperatersMapper operatersMapper;

    @Test
    void contextLoads() {

        List<Operaters> operaters = operatersMapper.queryOperatersList();
        for (Operaters operaters1:operaters){
            System.out.println(operaters1);
        }
    }

}
