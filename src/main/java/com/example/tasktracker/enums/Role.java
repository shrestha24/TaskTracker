package com.example.tasktracker.enums;

public enum Role {

    USER("user"),
    ADMIN("admin");

    public String value;
    Role(String value){
        this.value =value;
    }

}
