package com.example.tasktracker.enums;

public enum TaskState {
    NEW("NEW"),
    INPROGRESS("INPROGRESS"),
    COMPLETED("COMPLETED"),
    CANCELED("CANCELED"),;

    public String value;

    TaskState(String value){
        this.value = value;
    }

}
