package com.face.gmail.manage.web;

import org.springframework.http.HttpMethod;
import org.springframework.lang.Nullable;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum  ManageLevel {

    SECOND(2,"base_catalog2"),

    THIRD(3,"base_catalog3");

    private static final Map<Integer, ManageLevel> manageLevels = new ConcurrentHashMap<>(3);

    private String tableName;

    private Integer level;

    private ManageLevel(Integer level, String tableName){
        this.tableName = tableName;
        this.level = level;
    }

    static {
        for (ManageLevel manageLevel : values()) {
            manageLevels.put(manageLevel.level, manageLevel);
        }
    }

    @Nullable
    public static ManageLevel resolve(@Nullable Integer level) {
        return level != null ? manageLevels.getOrDefault(level,null) : null;
    }

    public static boolean matches(Integer level) {
        return (resolve(level) != null);
    }

    @Nullable
    public String getTableName() {
        return tableName;
    }
}
