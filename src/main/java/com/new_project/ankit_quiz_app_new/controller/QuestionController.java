package com.new_project.ankit_quiz_app_new.controller;

import com.new_project.ankit_quiz_app_new.model.Question;
import com.new_project.ankit_quiz_app_new.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("/allQuestions")
    public ResponseEntity<?> getAllQuestions(){
       return  questionService.getAllQuestions();
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<?> getQuestionsByCategory(@PathVariable String category){
      return questionService.getQuestionsByCategory(category);
    }
    @PostMapping("/addQuestion")
    public ResponseEntity<?> addQuestion(@RequestBody Question question){
       return questionService.addQuestion(question);
    }
    @PutMapping("/updateQuestion/{id}")
    public String updateQuestion(@PathVariable int id, @RequestBody Question question) {
        return questionService.updateQuestion(id, question);
    }

    @DeleteMapping("/deleteQuestion/{id}")
    public String deleteQuestion(@PathVariable int id) {
        return questionService.deleteQuestion(id);
    }

}
