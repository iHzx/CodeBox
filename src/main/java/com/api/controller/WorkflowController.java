package com.api.controller;


import com.alibaba.fastjson.JSONObject;
import com.api.core.exception.CodeBoxException;
import com.api.core.model.ResponseModel;
import com.api.core.util.ReqUtil;
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


    @PostMapping("/listById")
    public ResponseModel listById(HttpServletRequest request){
        JSONObject obj = ReqUtil.getData(request);
        Long id = obj.getLong("wId");
        if(null==id)
            throw new CodeBoxException("ID为空");
        workflowService.addView(id);
        return new ResponseModel("成功",workflowService.listById(id));
    }

    @PostMapping("/addDown")
    public ResponseModel addDown(HttpServletRequest request){
        JSONObject obj = ReqUtil.getData(request);
        Long id = obj.getLong("wId");
        log.info("安装数量+1");
        if(null==id)
            throw new CodeBoxException("ID为空");
        return new ResponseModel("成功",workflowService.addDown(id));
    }

    @PostMapping("/listByTId")
    public ResponseModel listByTId(HttpServletRequest request){
        JSONObject obj = ReqUtil.getData(request);
        Long id = obj.getLong("tId");
        if(null==id)
            throw new CodeBoxException("类型ID为空");
        return new ResponseModel("成功",workflowService.listByTId(id));
    }

}
