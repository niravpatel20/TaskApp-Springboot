package com.nirav.taskapp.service;

import com.nirav.taskapp.api.request.AddNoteRequest;
import com.nirav.taskapp.api.response.AddNoteResponse;
import com.nirav.taskapp.api.response.GetTaskByIdResponse;
import com.nirav.taskapp.models.NoteEntity;
import com.nirav.taskapp.models.TaskEntity;
import com.nirav.taskapp.repository.NoteRepository;
import com.nirav.taskapp.utils.TaskAppUtils.STATUS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    @Autowired
    TaskService taskService;
    @Autowired
    NoteRepository noteRepository;
    public AddNoteResponse addNote(AddNoteRequest request) {

        System.out.println("AddNoteRequest :: " + request);

        AddNoteResponse response = new AddNoteResponse();

       GetTaskByIdResponse taskByIdResponse =  taskService.getTaskById(request.getTask_id());

        System.out.println("GetTaskByIdResponse :: " + taskByIdResponse);

       if(taskByIdResponse.getStatus().equals(STATUS.SUCCESS)){
           TaskEntity task = taskByIdResponse.getTask();

           NoteEntity noteToSave = new NoteEntity();
           noteToSave.setTitle(request.getTitle());
           noteToSave.setBody(request.getBody());
           noteToSave.setTask(task);

           NoteEntity note=  noteRepository.save(noteToSave);

           response.setStatus(STATUS.SUCCESS);
           response.setId(note.getId());

           return response;
       }

       response.setStatus(STATUS.FAILURE);
       response.setErrorDescription("Task does not exist with provided id");

       return response;
    }
}
