package com.api.service;

import com.api.entity.Workflow;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huzhaoxi
 * @since 2019-09-27
 */
public interface IWorkflowService extends IService<Workflow> {


    List<Workflow> list_work();

}
