package com.xinsu.controller;

import com.xinsu.pojo.Operaters;
import com.xinsu.pojo.Result;
import com.xinsu.service.OPeratersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.List;
import java.util.UUID;

/**
 * @author yeyike
 * @date 2020/7/13 - 22:15
 */
@RestController
@Controller
@CrossOrigin
public class OperatersController {
    @Autowired
    OPeratersServiceImpl oPeratersService;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @RequestMapping("/getOperaters")
    public Result getOperaters(String name, String passwd){

        Operaters operaters =  oPeratersService.queryOperatersByName(name);
        if (operaters != null){
            if (operaters.getPasswd().equals(passwd)){
                String token = UUID.randomUUID()+"";
                redisTemplate.opsForValue().set(token,operaters, Duration.ofMinutes(30L));
                return new Result(token,"true");
            }else {
                return new Result("false");
            }
        }else {
            return new Result("false");
        }
    }
}
