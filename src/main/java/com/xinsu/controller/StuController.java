package com.xinsu.controller;

import com.xinsu.pojo.Record;
import com.xinsu.pojo.Result;
import com.xinsu.pojo.Stu;
import com.xinsu.service.RecordServiceImpl;
import com.xinsu.service.StuService;
import com.xinsu.service.StuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yeyike
 * @date 2020/7/15 - 19:52
 */
@RestController
@CrossOrigin
public class StuController {
    @Autowired
    StuServiceImpl stuService;
    @Autowired
    RecordServiceImpl recordService;
    @Autowired
    JavaMailSenderImpl mailSender;

    SimpleMailMessage mailMessage = new SimpleMailMessage();

    @RequestMapping("view/getStus")
    public List<Stu> getStus(){
        return stuService.queryStuList();
    }

    @RequestMapping("view/queryStuByID")
    public Stu queryStuByID(Integer ID){
        Stu stu = stuService.queryStuByID(ID);
        return stu;
    }
    @RequestMapping("view/addStu")
    public Result addStu(Stu stu){
        int result = stuService.addStu(stu);
        if (result > 0){
            mailMessage.setSubject("新素会员卡新用户通知");
            mailMessage.setText("今天您已成功购买新素会员卡");
            mailMessage.setTo(stu.getMail());
            mailMessage.setFrom("ad2248@foxmail.com");
            mailSender.send(mailMessage);
            return new Result("true");
        }else {
            return new Result("false");
        }
    }

    @RequestMapping("view/consumption")
    public Result consumption(Stu stu){
        Stu stu1 = stuService.queryStuByID(stu.getID());
        int price = stu1.getBalance() - stu.getBalance();
        int result1 = stuService.updateStu(stu);
        if (result1 > 0) {
            Record record = new Record("消费了"+price+"元",stu.getID());
            int result2 = recordService.addRecord(record);
            if (result2 > 0){
                mailMessage.setSubject("新素会员卡消费通知");
                mailMessage.setText("今天您已消费"+price+"元");
                mailMessage.setTo(stu.getMail());
                mailMessage.setFrom("ad2248@foxmail.com");
                mailSender.send(mailMessage);
                return new Result("true");
            }else {
                return new Result("false");
            }

        }else {
            return new Result("false");
        }

    }

    @RequestMapping("view/recharge")
    public Result recharge(Stu stu){
        Stu stu1 = stuService.queryStuByID(stu.getID());
        int price = stu.getBalance() - stu1.getBalance();
        int result1 = stuService.updateStu(stu);
        if (result1 > 0) {
            Record record = new Record("充值了"+String.valueOf(price)+"元",stu.getID());
            int result2 = recordService.addRecord(record);
            if (result2 > 0){
                mailMessage.setSubject("新素会员卡消费通知");
                mailMessage.setText("今天您已充值"+price+"元");
                mailMessage.setTo(stu.getMail());
                mailMessage.setFrom("ad2248@foxmail.com");
                mailSender.send(mailMessage);
                return new Result("true");
            }else {
                return new Result("false");
            }

        }else {
            return new Result("false");
        }

    }

    @RequestMapping("view/deleteStu")
    public Result deleteStu(Integer ID){
        Stu stu = stuService.queryStuByID(ID);
        int result1 = stuService.deleteStu(ID);
        if (result1 > 0){
            int result2 = recordService.deleteRecords(ID);
            if (result2 > 0){
                SimpleMailMessage mailMessage = new SimpleMailMessage();

                mailMessage.setSubject("新素会员卡注销通知");
                mailMessage.setText("今天您已将新素会员卡注销");
                mailMessage.setTo(stu.getMail());
                mailMessage.setFrom("ad2248@foxmail.com");
                mailSender.send(mailMessage);
                return new Result("true");
            }else {
                return new Result("false");
            }
        }else {
            return new Result("false");
        }
    }

}
