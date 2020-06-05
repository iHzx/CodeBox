package com.api.controller;

import com.api.entity.Workflow;
import com.api.service.IWorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 首页
 */
@Controller
public class IndexController {

    @Autowired
    IWorkflowService service;

    @RequestMapping("/")
    public String index(HttpServletRequest request){
//        List<Workflow> workflows = service.list_work();
//        request.setAttribute("list",workflows);
        return "index";
    }
}
