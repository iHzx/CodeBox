package com.api.controller;


import com.api.core.model.ResponseModel;
import com.api.entity.WorkflowType;
import com.api.service.IWorkflowTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huzhaoxi
 * @since 2019-09-27
 */
@RestController
@RequestMapping("/workflowType")
@Slf4j
public class WorkflowTypeController {

    @Autowired
    IWorkflowTypeService workflowTypeService;

    @PostMapping("/list")
    public ResponseModel list(HttpServletRequest request){
        return new ResponseModel("成功",workflowTypeService.list_type());
    }


}
