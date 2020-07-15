package com.xinsu.controller;

import com.xinsu.pojo.Operaters;
import com.xinsu.service.OPeratersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @RequestMapping("/getOperaters")
    public List<Operaters> getOperaters(){
        return oPeratersService.queryOperatersList();
    }
}
