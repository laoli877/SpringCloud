package com.example.controller;

import com.example.model.Student;
import com.example.util.WechatUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


//@CrossOrigin(origins = "https://www.baidu.com",methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
//@CrossOrigin
@RestController
@RequestMapping("/user")
public class HelloWorldController {
    @Value("${test.name}")
    String name;
    @RequestMapping("/index")
    public String index() {
        return "Hello World";
    }

    @RequestMapping(value = "/student")
    public Student student(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("++++++++++++++++++++++++++++++++");
        Student student=new Student();
        student.setNickName("Jimmy");
        student.setId(1L);
        student.setUserName(name);
//        response.setHeader("Access-Control-Allow-Origin","*");
        return student;
    }
}