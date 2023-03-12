package com.captian.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 性别枚举类
 *
 * @author: Captian
 * @create: 2023-03-11
 **/

@Getter
@AllArgsConstructor
public enum SexEnum {

    MAN(0, "男"),
    WOMAN(1, "女"),
    UNKNOWN(2, "未知");

    private Integer code;
    private String desc;


    public static String getValue(Integer code) {
        SexEnum[] sexEnums = values();
        for (SexEnum sexEnum : sexEnums) {
            if (sexEnum.getCode().equals(code)) {
                return sexEnum.getDesc();
            }
        }
        return null;
    }
}
