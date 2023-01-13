package com.developersCorner.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.developersCorner.dto.QuestionDto;
import com.developersCorner.exception.ResourceNotFoundException;
import com.developersCorner.model.Question;

@Repository("questionDao")
public class QuestionDaoImpl extends AbstractDao implements QuestionDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> findAllQuestions() {
		@SuppressWarnings("deprecation")
		Criteria criteria = getSession().createCriteria(Question.class);
		
		return (List<Question>) criteria.list();
	}

	@Override
	public Question findById(Long id) {
		String hql = "FROM Question Q WHERE Q.id = ?1";
		Question question = getSession().createQuery(hql, Question.class)
				.setParameter(1, id)
				.uniqueResult();
		
		if(question == null) throw new ResourceNotFoundException("Question id: " + id + " was not found.");
		return question;
	}

	@Override
	public Question findByUsername(String username) {
		String hql = "FROM QUESTION Q WHERE Q.username = ?1";
		Question question = getSession().createQuery(hql, Question.class)
				.setParameter(1, username)
				.uniqueResult();

		if(question == null) throw new ResourceNotFoundException("Question id: " + username + " was not found.");
		
		return question;
	}

	@Override
	public List<Question> findByUserId(Long userId) {
		String hql = "FROM Question Q WHERE Q.user.id = ?1";
		List<Question> questions = getSession().createQuery(hql, Question.class)
				.setParameter(1, userId)
				.getResultList();
	
		if(questions.isEmpty()) throw new ResourceNotFoundException("Question(s) userId: " + userId + " was not found.");
		return questions.parallelStream().collect(Collectors.toList());
	}
	
	@Override
	public void saveQuestion(Question question) {
		persist(question);
	}

	@Override
	public void updateQuestion(Long id, QuestionDto dto) {
		String hql = "UPDATE Question Q SET Q.username = ?1,"
				+ " Q.tags = ?2, Q.question = ?3 WHERE Q.id = ?4";
		getSession().createQuery(hql)
				.setParameter(1, dto.getUsername())
				.setParameter(2, dto.getTags())
				.setParameter(3, dto.getQuestion())
				.setParameter(4, id)
				.executeUpdate();
		
	}

	@Override
	public void deleteById(Long id) {
		String hql = "DELETE Question q WHERE q.id = ?1";
		getSession().createQuery(hql)
				.setParameter(1, id)
				.executeUpdate();
	}

	
	
}
