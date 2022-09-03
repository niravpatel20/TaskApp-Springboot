package com.nirav.taskapp.controller;

import com.nirav.taskapp.api.request.AddNoteRequest;
import com.nirav.taskapp.api.response.AddNoteResponse;
import com.nirav.taskapp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    NoteService noteService;

    @PostMapping
    public AddNoteResponse addNote(@RequestBody AddNoteRequest request){
        return noteService.addNote(request);
    }
}
