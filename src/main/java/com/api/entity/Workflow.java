package com.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author huzhaoxi
 * @since 2019-09-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Workflow extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(value = "w_id", type = IdType.AUTO)
    private Long wId;

    private String backgroundColor;

    private String icon;

    /**
     * 捷径名称
     */
    private String wName;

    private Long tId;

    /**
     * 下载次数
     */
    private Long down;

    /**
     * 简介
     */
    private String miaoshu;

    private LocalDateTime creatTime;

    private String url;

    /**
     * 截图
     */
    private String image;

    /**
     * 浏览次数
     */
    private String view;

    /**
     * 是否删除:0>未删除;1>删除
     */
    private Integer isDelete;


}
