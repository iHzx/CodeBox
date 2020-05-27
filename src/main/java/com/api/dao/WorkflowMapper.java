package com.api.dao;

import com.api.entity.Workflow;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huzhaoxi
 * @since 2019-09-27
 */

public interface WorkflowMapper extends BaseMapper<Workflow> {

    List<Workflow> list_work();

    Workflow listById(Long wid);

    Integer addDown(Long wid);

    Integer addView(Long wid);

    List<Workflow> listByTId(Long tid);

}
