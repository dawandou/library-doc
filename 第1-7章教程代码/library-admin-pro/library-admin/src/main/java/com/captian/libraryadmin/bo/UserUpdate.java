package com.captian.libraryadmin.bo;

import java.time.LocalDateTime;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

/**
 * 用户表(User)BO类
 *
 * @author Captian
 * @since 2023-03-09 12:03:56
 */
@Data
public class UserUpdate implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 689453599353810238L;

    /**
     * 用户ID
     */
    private Long id;
    /**
     * 部门ID
     */
    private Long deptId;
    /**
     * 用户账号
     */
    private String username;
    /**
     * 用户姓名
     */
    private String realName;
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
     * 最后修改密码的日期
     */
    private LocalDateTime lastPasswordResetTime;
    /**
     * 备注
     */
    private String remark;

}
