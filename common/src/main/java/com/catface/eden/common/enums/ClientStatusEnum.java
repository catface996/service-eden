package com.catface.eden.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.catface.common.enums.BaseEnum;

/**
 * @author catface
 * @since 2022/8/11
 */
public enum ClientStatusEnum implements BaseEnum {

    /**
     * 客户状态枚举
     */
    AVAILABLE("AVAILABLE", "可用"),

    DISABLE("DISABLE", "不可用"),


    ;

    @EnumValue
    private final String code;

    private final String desc;

    ClientStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public String getCode() {
        return code;
    }
}
