package com.yang.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author laoyang
 * @since 2021-08-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 父菜单id
     */
    private Integer pid;

    /**
     * 菜单排序
     */
    private String zindex;

    /**
     * 权限分类（0 菜单；1 功能）
     */
    private Integer istype;

    /**
     * 描述
     */
    private String descpt;

    /**
     * 菜单编号
     */
    private String code;

    /**
     * 菜单图标名称
     */
    private String icon;

    /**
     * 菜单url
     */
    private String page;

    /**
     * 添加时间
     */
    private LocalDateTime insertTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
