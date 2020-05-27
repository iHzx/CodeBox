package com.api.dao;

import com.api.entity.WorkflowType;
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
public interface WorkflowTypeMapper extends BaseMapper<WorkflowType> {

    List<WorkflowType> list_type();


}
