package com.captian.admin.modules.user.entity;

import java.time.LocalDateTime;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

/**
 * 用户表(User)实体类
 *
 * @author captian
 * @since 2023-03-13 10:01:21
 */
@Data
@TableName(value = "lib_user")
public class User implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = -69574044228951047L;

    /**
     * 用户ID
     */
    private Long id;
    /**
     * 部门ID
     */
    private Long deptId;
    /**
     * 账号名
     */
    private String realName;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 用户性别（0男 1女 2未知）
     */
    private Integer sex;
    /**
     * 头像地址
     */
    private String avatar;
    /**
     * 帐号状态（0正常 1停用）
     */
    private Integer status;
    /**
     * 最后登录时间
     */
    private LocalDateTime loginDate;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
    /**
     * 最后修改密码的日期
     */
    private LocalDateTime lastPasswordResetTime;
    /**
     * 备注
     */
    private String remark;

}
