package com.captian.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 状态枚举类
 *
 * @author: Captian
 * @create: 2023-03-11
 **/

@Getter
@AllArgsConstructor
public enum StatusEnum {

    NORMAL(0, "正常"),
    STOP(1, "停用"); //停用或冻结

    private Integer code;
    private String desc;


    public static String getValue(Integer code) {
        StatusEnum[] statusEnums = values();
        for (StatusEnum statusEnum : statusEnums) {
            if (statusEnum.getCode().equals(code)) {
                return statusEnum.getDesc();
            }
        }
        return null;
    }

}
