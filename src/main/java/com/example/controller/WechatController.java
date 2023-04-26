package com.example.controller;

import com.example.util.WechatUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/wechat")
public class WechatController {
    @RequestMapping("/test")
    public String test(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter write= response.getWriter();
        String timestamp=request.getParameter("timestamp");
        String nonce=request.getParameter("nonce");
        String signature=request.getParameter("signature");
        String echostr=request.getParameter("echostr");

        if(WechatUtils.checkSignature(timestamp,nonce,signature)){
            write.print(echostr);
            write.print("============配置成功============");
        }else{
            write.print("============配置失败============");
        }
        write.flush();
        write.close();
        System.out.println("++++++++++++++++++++=");
        return "Hello World";
    }

}
