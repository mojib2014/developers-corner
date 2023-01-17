package com.developersCorner.service;

import java.util.List;

import com.developersCorner.dto.QuestionDto;
import com.developersCorner.model.Question;

public interface QuestionService {
	
	List<Question> findAllQuestions() throws Exception;
	Question findById(Long id);
	Question findByUsername(String username);
	List<Question> findByUserId(Long userId);
	void saveQuestion(QuestionDto Question);
	void updateQuestion(Long id, QuestionDto Question);
	void deleteById(Long id);
}
