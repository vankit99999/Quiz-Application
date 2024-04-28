package com.new_project.ankit_quiz_app_new.dao;

import com.new_project.ankit_quiz_app_new.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz, Integer> {
}
