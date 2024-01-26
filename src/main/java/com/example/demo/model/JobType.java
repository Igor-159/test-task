package com.example.demo.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum JobType {
    PRINT("print"),
    COPY("copy"),
    SCAN("scan"),
    FAX("fax");

    private static Map<String, JobType> ID_MAP = new HashMap<>();

    static {
        Arrays.stream(values()).forEach(value -> ID_MAP.put(value.getValue(), value));
    }

    private final String value;

    JobType(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static JobType getByValue(final String value) {
        return ID_MAP.get(value);
    }
}
