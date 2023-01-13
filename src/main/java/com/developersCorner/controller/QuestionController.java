package com.developersCorner.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.developersCorner.dto.QuestionDto;
import com.developersCorner.model.Question;
import com.developersCorner.service.QuestionService;

@RestController
@RequestMapping(value = "/user")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@RequestMapping(value = "/questions", method = RequestMethod.GET)
	public ResponseEntity<List<Question>> listQuestions() throws Exception {
		List<Question> questions = questionService.findAllQuestions();
		return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/questions", method = RequestMethod.POST)
	public ResponseEntity<Void> createQuestion(@RequestBody @Valid QuestionDto dto) {
		questionService.saveQuestion(dto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/questions/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateQuestion(@PathVariable(value = "id") Long id, @RequestBody @Valid QuestionDto dto) {
		System.out.println(dto.toString());
		questionService.updateQuestion(id, dto);
		
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/questions/{id}", method = RequestMethod.GET)
	public ResponseEntity<Question> getQuestionById(@PathVariable(value = "id") Long id) {
		Question question = questionService.findById(id);
		
		return new ResponseEntity<Question>(question, HttpStatus.ACCEPTED);
	}
	@RequestMapping(value = "/questions/{username}", method = RequestMethod.GET)
	public ResponseEntity<Question> getQuestionByUsername(@PathVariable(value = "username") String username) {
		Question question = questionService.findByUsername(username);
		
		return new ResponseEntity<Question>(question, HttpStatus.ACCEPTED);
	}
	@RequestMapping(value = "/questions/question", method = RequestMethod.GET)
	public ResponseEntity<List<Question>> getQuestionByUserId(@RequestParam(value = "userId") Long userId) {
		List<Question> questions = questionService.findByUserId(userId);
		
		return new ResponseEntity<List<Question>>(questions, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/questions/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteQuestion(@PathVariable(value = "id") Long id) {
		questionService.deleteById(id);
		
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
}
