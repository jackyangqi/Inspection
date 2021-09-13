package com.yang.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author jack杨
 * @since 2021-09-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 微信openid
     */
    private String openid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 头像
     */
    private String headimg;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 注册时间
     */
    private LocalDateTime insertTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除（0：正常；1：已删）
     */
    private Boolean isDel;

    /**
     * 是否在职（0：正常；1，离职）
     */
    private Boolean isJob;

    /**
     * 短信验证码
     */
    private String mcode;

    /**
     * 绑定用户客户端ip等信息（用于锁定用户设备）
     */
    private String userIp;

    /**
     * 用户的权限
     */
    private Integer type;


}
