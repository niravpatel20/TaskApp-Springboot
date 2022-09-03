package com.nirav.taskapp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity(name = "notes")
@Data
public class NoteEntity extends BaseEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    @JsonBackReference
    TaskEntity task;

    @Column(nullable = false)
    String title;

    @Column(nullable = false)
    String body;


}
