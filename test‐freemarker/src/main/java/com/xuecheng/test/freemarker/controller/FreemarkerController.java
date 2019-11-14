package com.xuecheng.test.freemarker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @Date 2019/9/14 9:47
 */
@RequestMapping("/freemarker")
@Controller
public class FreemarkerController {
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping("/test1")
    public String freemarker(Map<String, Object> map){
        //返回模板文件名称
        map.put("name","黑马程序员");
        return "test1";
    }
    @RequestMapping("/banner")
    public String index_banner(Map<String, Object> map){
        //返回模板文件名称
        ResponseEntity<Map> forEntity = restTemplate.getForEntity("http://localhost:31001/cms/config/getmodel/5a791725dd573c3574ee333f", Map.class);
        Map body = forEntity.getBody();
        map.putAll(body);
        return "index_banner";
    }

    @RequestMapping("/course")
    public String course(Map<String, Object> map){
        //返回模板文件名称
        ResponseEntity<Map> forEntity = restTemplate.getForEntity("http://localhost:31200/course/courseview/402885816243d2dd016243f24c030002", Map.class);
        Map body = forEntity.getBody();
        map.putAll(body);
        return "course";
    }
}