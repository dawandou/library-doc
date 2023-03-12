package com.captian.libraryadmin.bo;

import lombok.Data;
import com.captian.constant.BasePage;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * 用户表(User)BO类
 *
 * @author Captian
 * @since 2023-03-09 12:03:56
 */
@Data
public class UserPage extends BasePage implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = -43659243917952524L;

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
