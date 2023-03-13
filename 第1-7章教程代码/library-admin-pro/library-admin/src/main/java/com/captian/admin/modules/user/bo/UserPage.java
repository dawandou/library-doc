package com.captian.admin.modules.user.bo;

import lombok.Data;
import com.captian.constant.BasePage;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

/**
 * 用户表(User)BO类
 *
 * @author captian
 * @since 2023-03-13 10:01:24
 */
@Data
public class UserPage extends BasePage implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = -99269121703622624L;

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 用户账号
     */
    private String username;

    /**
     * 帐号状态（0正常 1停用）
     */
    private Integer status;
}
