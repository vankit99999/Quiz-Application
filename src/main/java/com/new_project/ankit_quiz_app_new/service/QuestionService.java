package com.new_project.ankit_quiz_app_new.service;

import com.new_project.ankit_quiz_app_new.model.Question;
import com.new_project.ankit_quiz_app_new.dao.QuestionDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    private static final Logger logger = LoggerFactory.getLogger(QuestionService.class);
    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<?> getAllQuestions() {
        try{
        logger.info("starting db call");
        List<Question> questionList = questionDao.findAll();
        logger.info("ending Db call : {}", questionList);
        return new ResponseEntity<>(questionList, HttpStatus.OK);}
        catch(Exception e){
            e.printStackTrace();
            logger.info("errorMessage",e.getMessage());
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> getQuestionsByCategory(String category) {
        try{
            return new ResponseEntity<>(questionDao.getByCategory(category), HttpStatus.OK);}
        catch(Exception e){
            e.printStackTrace();
            logger.info("errorMessage",e.getMessage());
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> addQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    public String updateQuestion(int id, Question updatedQuestion) {
        Question existingQuestion = questionDao.findById(id).orElse(null);
        if (existingQuestion == null) {
            return "Question not found";
        }
        existingQuestion.setCategory(updatedQuestion.getCategory());
        existingQuestion.setDifficultyLevel(updatedQuestion.getDifficultyLevel());
        existingQuestion.setOption1(updatedQuestion.getOption1());
        existingQuestion.setOption2(updatedQuestion.getOption2());
        existingQuestion.setOption3(updatedQuestion.getOption3());
        existingQuestion.setOption4(updatedQuestion.getOption4());
        existingQuestion.setQuestionTitle(updatedQuestion.getQuestionTitle());
        existingQuestion.setRightAnswer(updatedQuestion.getRightAnswer());
        questionDao.save(existingQuestion);
        return "Question updated successfully";
    }

    public String deleteQuestion(int id) {
        if (questionDao.existsById(id)) {
            questionDao.deleteById(id);
            return "Question deleted successfully";
        } else {
            return "Question not found";
        }
    }
}
