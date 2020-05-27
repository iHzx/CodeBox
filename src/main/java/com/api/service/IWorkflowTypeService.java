package com.api.service;

import com.api.entity.WorkflowType;
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
public interface IWorkflowTypeService extends IService<WorkflowType> {

    List<WorkflowType> list_type();

}
