package com.nirav.taskapp.controller;

import com.nirav.taskapp.api.request.CreateTaskRequest;
import com.nirav.taskapp.api.response.BaseResponse;
import com.nirav.taskapp.api.response.CreatTaskResponse;
import com.nirav.taskapp.api.response.GetAllTasksResponse;
import com.nirav.taskapp.api.response.GetTaskByIdResponse;
import com.nirav.taskapp.models.TaskEntity;
import com.nirav.taskapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/")
    public CreatTaskResponse createTask(@RequestBody CreateTaskRequest request){
        return taskService.createTask(request);
    }

    @GetMapping("/")
    public GetAllTasksResponse getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public GetTaskByIdResponse getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteTaskById(@PathVariable Long id){
        return taskService.deleteTaskById(id);
    }

}
