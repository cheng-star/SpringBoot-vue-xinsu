package com.xinsu.controller;

import com.xinsu.config.RedisConfig;
import com.xinsu.pojo.Operaters;
import com.xinsu.pojo.Result;
import com.xinsu.service.OPeratersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
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

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @GetMapping("/getUserOfLogin")
    public Result getUserOfLogin(HttpServletRequest request)throws UnsupportedEncodingException{
        String token = request.getHeader("Authorization");
        token = token==null ? "" : token;
        Object user = redisTemplate.opsForValue().get(token);
        if (user != null){
            return new Result(user,"true");
        }
        return new Result("false");
    }

    @RequestMapping("/login")
    public Result getOperaters(String name, String passwd) throws UnknownHostException {

        Operaters operaters =  oPeratersService.queryOperatersByName(name);
        if (operaters != null){
            if (operaters.getPasswd().equals(passwd)){
                String token = UUID.randomUUID()+"";
                //opsForValue().set(token,operaters, Duration.ofMinutes(30L));
                redisTemplate.opsForValue().set(token,operaters,Duration.ofMinutes(30L));
                return new Result("true",token);
            }else {
                return new Result("false");
            }
        }else {
            return new Result("false");
        }
    }
}
