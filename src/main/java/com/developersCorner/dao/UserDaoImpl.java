/*
 * package com.developersCorner.dao;
 * 
 * import java.util.List;
 * 
 * import org.hibernate.Criteria; import
 * org.springframework.stereotype.Repository;
 * 
 * import com.developersCorner.model.User;
 * 
 * @Repository("userDao") public class UserDaoImpl extends AbstractDao
 * implements UserDao {
 * 
 * @SuppressWarnings("unchecked")
 * 
 * @Override public List<User> findAllUsers() {
 * 
 * @SuppressWarnings("deprecation") Criteria criteria =
 * getSession().createCriteria(User.class); return (List<User>) criteria.list();
 * }
 * 
 * @Override public User findById(Long id) { // TODO Auto-generated method stub
 * return null; }
 * 
 * @Override public User findByName(String name) { // TODO Auto-generated method
 * stub return null; }
 * 
 * @Override public void saveUser(User user) { // TODO Auto-generated method
 * stub
 * 
 * }
 * 
 * @Override public void updateUser(User user) { // TODO Auto-generated method
 * stub
 * 
 * }
 * 
 * @Override public void deleteById(Long id) { // TODO Auto-generated method
 * stub
 * 
 * }
 * 
 * 
 * }
 */