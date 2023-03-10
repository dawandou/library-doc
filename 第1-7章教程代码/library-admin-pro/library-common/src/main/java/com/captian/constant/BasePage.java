package com.captian.constant;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Captian
 * @create: 2023-03-09
 **/

@Data
public class BasePage implements Serializable {

    private static final long serialVersionUID = -2560796196204101092L;

    /**
     * 每页显示条数，默认 10
     */
    protected long size = 10;

    /**
     * 当前页
     */
    protected long current = 1;

}
