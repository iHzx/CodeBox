package com.api.service.impl;

import com.api.dao.WorkflowMapper;
import com.api.entity.WorkflowType;
import com.api.dao.WorkflowTypeMapper;
import com.api.service.IWorkflowTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huzhaoxi
 * @since 2019-09-27
 */
@Service
public class WorkflowTypeServiceImpl extends ServiceImpl<WorkflowTypeMapper, WorkflowType> implements IWorkflowTypeService {


    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    WorkflowTypeMapper dao;

    @Override
    public List<WorkflowType> list_type() {
        return dao.list_type();
    }
}
