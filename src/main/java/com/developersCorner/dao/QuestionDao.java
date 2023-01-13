package com.developersCorner.dao;

import java.util.List;

import com.developersCorner.dto.QuestionDto;
import com.developersCorner.model.Question;

public interface QuestionDao {
	
	List<Question> findAllQuestions();
	Question findById(Long id);
	Question findByUsername(String username);
	List<Question> findByUserId(Long userId);
	void saveQuestion(Question Question);
	void updateQuestion(Long id, QuestionDto Question);
	void deleteById(Long id);
}
