
package com.developersCorner.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.developersCorner.exception.ResourceNotFoundException;
import com.developersCorner.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {

		@SuppressWarnings("deprecation")
		Criteria criteria = getSession().createCriteria(User.class);
		return (List<User>) criteria.list();
	}

	@Override
	public User findById(Long id) {
		String hql = "FROM User U WHERE U.id = ?1";
		Query query = getSession().createQuery(hql);
		query.setParameter(1, id);
		List<?> result = query.getResultList();
		if (result.isEmpty())
			throw new ResourceNotFoundException("User id: " + id + " does not exist.");
		return (User) result.get(0);
	}

	@Override
	public Optional<User> findByEmail(String email) {
		@SuppressWarnings("deprecation")
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("email", email));
		User user = (User) criteria.uniqueResult();
		return Optional.of(user);
	}

	@Override
	public void saveUser(User user) {
		persist(user);
	}

	@Override
	public void updateUser(User user) {
		String hql = "UPDATE User U SET U.firstName = ?1," + " U.lastName = ?2, U.nickName = ?3, U.email = ?4,"
				+ " U.password = ?5, U.type = ?6 WHERE U.id = ?7";
		Query query = getSession().createQuery(hql);
		query.setParameter(1, user.getFirstName());
		query.setParameter(2, user.getLastName());
		query.setParameter(3, user.getNickName());
		query.setParameter(4, user.getEmail());
		query.setParameter(5, user.getPassword());
		query.setParameter(6, user.getType());
		query.setParameter(7, user.getId());
		query.executeUpdate();
	}

	@Override
	public void deleteById(Long id) {
		String hql = "DELETE User U WHERE U.id = ?1";
		Query query = getSession().createQuery(hql);
		query.setParameter(1, id);
		query.executeUpdate();
	}

}
