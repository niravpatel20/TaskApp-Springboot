package com.nirav.taskapp.api.request;

import lombok.Data;

@Data
public class AddNoteRequest {

    Long task_id;
    String title;
    String body;
}
