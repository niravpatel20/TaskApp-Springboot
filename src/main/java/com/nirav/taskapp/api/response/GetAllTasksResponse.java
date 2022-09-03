package com.nirav.taskapp.api.response;

import com.nirav.taskapp.models.TaskEntity;
import lombok.Data;

import java.util.List;

@Data
public class GetAllTasksResponse extends BaseResponse{

    List<TaskEntity> tasks;

}
