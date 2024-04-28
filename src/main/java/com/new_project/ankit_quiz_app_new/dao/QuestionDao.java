package com.new_project.ankit_quiz_app_new.dao;

import com.new_project.ankit_quiz_app_new.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
    List<Question> getByCategory(String category);

}
