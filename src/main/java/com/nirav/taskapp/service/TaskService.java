package com.nirav.taskapp.service;

import com.nirav.taskapp.api.request.CreateTaskRequest;
import com.nirav.taskapp.api.response.BaseResponse;
import com.nirav.taskapp.api.response.CreatTaskResponse;
import com.nirav.taskapp.api.response.GetAllTasksResponse;
import com.nirav.taskapp.api.response.GetTaskByIdResponse;
import com.nirav.taskapp.models.TaskEntity;
import com.nirav.taskapp.repository.TaskRepository;
import com.nirav.taskapp.utils.TaskAppUtils.STATUS;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public CreatTaskResponse createTask(CreateTaskRequest request) {

        TaskEntity taskToSave = new TaskEntity();
        taskToSave.setTitle(request.getTitle());
        taskToSave.setDueDate(request.getDueDate());
        taskToSave.setCompleted(request.getCompleted());

        TaskEntity task = taskRepository.save(taskToSave);
        System.out.println("Task created :: " + task);

        CreatTaskResponse response = new CreatTaskResponse();
        response.setId(task.getId());
        response.setStatus(STATUS.SUCCESS);

        return response;

    }

    public GetAllTasksResponse getAllTasks() {

        GetAllTasksResponse response = new GetAllTasksResponse();

        List<TaskEntity> tasks = taskRepository.findAll();

        response.setTasks(tasks);
        response.setStatus(STATUS.SUCCESS);

        return response;
    }

    public GetTaskByIdResponse getTaskById(Long id) {

        GetTaskByIdResponse response = new GetTaskByIdResponse();

        try{

            TaskEntity task = taskRepository.findById(id).get();
            response.setStatus(STATUS.SUCCESS);
            response.setTask(task);

        } catch (Exception e){
            response.setStatus(STATUS.FAILURE);
            response.setErrorDescription("Task does not exist with provided id");
        }

        return response;
    }

    public BaseResponse deleteTaskById(Long id){

        BaseResponse response = new BaseResponse();

        try{
            taskRepository.deleteById(id);

        } catch (Exception e){
            response.setStatus(STATUS.FAILURE);
            response.setErrorDescription("Something went wrong");
            return response;
        }

        response.setStatus(STATUS.SUCCESS);

        return response;

    }
}
