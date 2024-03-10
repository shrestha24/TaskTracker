package com.example.tasktracker.enums;

public enum UserState {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE"),

    DELETED("DELETED"),;

    public String value;

    UserState(String value) {
        this.value = value;
    }
}
