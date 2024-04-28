package com.new_project.ankit_quiz_app_new.service;

import com.new_project.ankit_quiz_app_new.dao.QuestionDao;
import com.new_project.ankit_quiz_app_new.dao.QuizDao;
import com.new_project.ankit_quiz_app_new.model.Question;
import com.new_project.ankit_quiz_app_new.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

}
