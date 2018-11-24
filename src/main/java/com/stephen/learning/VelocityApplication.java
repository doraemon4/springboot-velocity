package com.stephen.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: jack
 * @Date: 2018/11/8 11:47
 * @Description:
 */
@Controller
@SpringBootApplication
public class VelocityApplication {

    @RequestMapping("/")
    public String queryPage(){
        return "nicePage";
    }
    public static void main(String[] args) {
        SpringApplication.run(VelocityApplication.class, args);
    }
}
