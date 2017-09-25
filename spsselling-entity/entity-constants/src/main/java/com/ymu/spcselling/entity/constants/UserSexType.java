package com.ymu.spcselling.entity.constants;

/**
 * 会员性别类型。
 */
public enum UserSexType {

    USER_SEX_MALE("男"),
    USER_SEX_FEMALE("女");

    private final String value;

    UserSexType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
