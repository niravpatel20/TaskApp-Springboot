package com.nirav.taskapp.api.response;

import com.nirav.taskapp.models.TaskEntity;
import lombok.Data;

@Data
public class GetTaskByIdResponse extends BaseResponse{

    TaskEntity task;

}
