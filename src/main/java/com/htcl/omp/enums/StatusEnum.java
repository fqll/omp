package com.htcl.omp.enums;

/**
 * Created by sam on 2020-01-14.09:47
 */
public enum StatusEnum {
    INVALID_STATUS("0", "无效"),
    VALID_STATUS("1", "有效");

    private String value;
    private String name;

    StatusEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
