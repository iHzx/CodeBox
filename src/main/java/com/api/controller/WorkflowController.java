package com.api.controller;

import com.api.core.model.ResponseModel;
import com.api.service.IWorkflowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huzhaoxi
 * @since 2019-09-27
 */
@RestController
@RequestMapping("/workflow")
@Slf4j
public class WorkflowController {

    @Autowired
    IWorkflowService workflowService;

    @PostMapping("/list")
    public ResponseModel list(HttpServletRequest request){
        return new ResponseModel("成功",workflowService.list_work());
    }


}
