package com.nirav.taskapp.api.response;

import com.nirav.taskapp.utils.TaskAppUtils;
import lombok.Data;

@Data
public class BaseResponse {

    TaskAppUtils.STATUS status;
    String errorDescription;

}
