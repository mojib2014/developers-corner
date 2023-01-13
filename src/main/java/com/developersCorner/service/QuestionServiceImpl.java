package com.developersCorner.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developersCorner.dao.QuestionDao;
import com.developersCorner.dao.UserDao;
import com.developersCorner.dto.QuestionDto;
import com.developersCorner.model.Question;
import com.developersCorner.model.User;

@Service("questionService")
@Transactional
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionDao questionDao;
	@Autowired
	private UserDao userDao;

	@Override
	public List<Question> findAllQuestions() throws Exception {
		List<Question> questions = questionDao.findAllQuestions();

		if (questions.isEmpty())
			throw new Exception("There are no questions.");
		return questions;
	}

	@Override
	public Question findById(Long id) {
		return questionDao.findById(id);
	}

	@Override
	public Question findByUsername(String username) {

		return questionDao.findByUsername(username);
	}
	
	@Override
	public List<Question> findByUserId(Long userId) {
		return questionDao.findByUserId(userId);
	}

	@Override
	public void saveQuestion(QuestionDto q) {
		User user = userDao.findById(q.getUserId());
		Question question = new Question(q.getUsername(), q.getTags(), q.getQuestion(), LocalDateTime.now(), user);
		questionDao.saveQuestion(question);
	}

	@Override
	public void updateQuestion(Long id, QuestionDto dto) {
		System.out.println(dto.toString());
		questionDao.updateQuestion(id, dto);
	}

	@Override
	public void deleteById(Long id) {
		questionDao.deleteById(id);
	}

}
