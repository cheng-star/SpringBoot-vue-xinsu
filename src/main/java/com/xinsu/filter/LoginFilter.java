package com.xinsu.filter;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.xinsu.pojo.Result;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/**
 * @author yeyike
 * @date 2020/7/17 - 10:49
 */
@WebFilter(urlPatterns = {"/view/*"})
@CrossOrigin
public class LoginFilter implements Filter {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //校验用户登录状态
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //Filter过滤器跨域处理
//        String origin = request.getHeader("Authorization");

//        response.setHeader("Access-Control-Allow-Origin",origin);
//        response.setHeader("Access-Control-Allow-Credentials","true");
//        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With,X-App-Id, X-Token");
//        response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");
//        response.setHeader("Access-Control-Max-Age", "3600");

//        // 如果是OPTIONS则结束请求
//        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
//            response.setStatus(HttpStatus.NO_CONTENT.value());
//            String string = JSONObject.toJSONString(new Result("false"));
//            response.setContentType("json/text;charset=utf-8");
//            PrintWriter out = response.getWriter();
//            out.write(string);
//        }

        //获取Headers中的参数
        String token = request.getHeader("Authorization");
        token = token==null ? "" : token;
        //查询Redis中是否存在
        Long expire = redisTemplate.getExpire(token);

        if (expire>0){//登录状态
            //重置token的时间
            redisTemplate.expire(token,30L, TimeUnit.MINUTES);
            //放行
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            String string = JSONObject.toJSONString(new Result("false"));
            response.setContentType("json/text;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write(string);
        }
    }
}
