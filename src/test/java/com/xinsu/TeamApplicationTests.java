package com.xinsu;

import com.xinsu.mapper.OperatersMapper;
import com.xinsu.pojo.Operaters;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class TeamApplicationTests {
    @Autowired
    private OperatersMapper operatersMapper;
    @Autowired
    JavaMailSenderImpl mailSender;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    void contextLoads() {

        Operaters operaters =  operatersMapper.queryOperatersByName("root");
        System.out.println(operaters);
        if (operaters.getPasswd().equals("abc12138de")){
            System.out.println("true");
        }
    }
    @Test
    public void mailText(){
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setSubject("新素会员卡消费通知");
        mailMessage.setText("今天您已消费");
        mailMessage.setTo("1522542949@qq.com");
        mailMessage.setFrom("ad2248@foxmail.com");
        mailSender.send(mailMessage);
    }
    @Test
    public void testRedis(){
        Operaters operaters = new Operaters();
        String token = UUID.randomUUID()+"";
        System.out.println(token);
        redisTemplate.opsForValue().set(token,operaters, Duration.ofMinutes(30L));
        System.out.println(redisTemplate.opsForValue().get(token));
    }

}
