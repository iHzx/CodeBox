package com.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页转发
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index()  {
        System.out.println("首页");
        return "forward:index.html";
    }
}
