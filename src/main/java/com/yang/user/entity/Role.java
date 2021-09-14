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
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色描述
     */
    private String descpt;

    /**
     * 角色编号
     */
    private String code;

    /**
     * 操作用户id
     */
    private Integer insertUid;

    /**
     * 添加数据时间
     */
    private LocalDateTime insertTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
