package com.ymu.spcselling.entity.constants;

/**
 * 会员类型
 */
public enum UserType {

    USER_TYPE_ORDINARY("普通会员"),
    USER_TYPE_BUSINESS("商家会员"),
    USER_TYPE_SYSTEM("系统会员");

    private final String value;

    UserType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
