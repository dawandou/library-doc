package com.captian.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 错误枚举类
 *
 * @author: Captian
 * @create: 2023-02-07
 **/

@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {

    SUCCESS("200", "成功"),
    FAIL("500", "失败");

    private String code;
    private String desc;

}
