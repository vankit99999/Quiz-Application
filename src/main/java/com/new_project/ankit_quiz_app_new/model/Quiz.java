package com.new_project.ankit_quiz_app_new.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
@Table(name ="quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ManyToMany
    private List<Question> questions;
}
