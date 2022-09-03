package com.nirav.taskapp.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "tasks")
@Data
public class TaskEntity extends BaseEntity{

    @Column(nullable = false)
    String title;

    @Column(nullable = false)
    Date dueDate;

    @Column(nullable = false)
    Boolean completed;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL,fetch =FetchType.LAZY)
    @ToString.Exclude
    @JsonManagedReference
    List<NoteEntity> notes = new ArrayList<>();

    public void setNotes(List<NoteEntity> notes) {
        this.notes = notes;
    }
}
