package com.api.service.impl;

import com.api.entity.Workflow;
import com.api.dao.WorkflowMapper;
import com.api.service.IWorkflowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class WorkflowServiceImpl extends ServiceImpl<WorkflowMapper, Workflow> implements IWorkflowService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    WorkflowMapper dao;

    @Override
    public List<Workflow> list_work() {
        return dao.list_work();
    }

    @Override
    public Workflow listById(Long wid) {
        return dao.listById(wid);
    }

    @Override
    public Integer addDown(Long wid) {
        return dao.addDown(wid);
    }

    @Override
    public Integer addView(Long wid) {
        return dao.addView(wid);
    }

    @Override
    public List<Workflow> listByTId(Long tid) {
        return dao.listByTId(tid);
    }
}
