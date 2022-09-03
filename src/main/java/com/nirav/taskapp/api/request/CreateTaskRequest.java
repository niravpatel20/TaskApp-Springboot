package com.nirav.taskapp.api.request;

import lombok.Data;

import java.util.Date;

@Data
public class CreateTaskRequest {

    String title;
    Date dueDate;
    Boolean completed;

}
