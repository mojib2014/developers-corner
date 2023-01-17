package com.developersCorner.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.developersCorner.dao.UserDao;

@Service("myUserDetialsService")
public class MyUserDetialsService implements CustomUserDetailsService {

	private final UserDao userDao;

	public MyUserDetialsService(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 final com.developersCorner.model.User user = userDao.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("user not found"));
	        if (user == null) {
	            throw new UsernameNotFoundException(username);
	        }
	        UserDetails u = org.springframework.security.core.userdetails.User.withUsername(user.getEmail()).password(user.getPassword()).authorities("USER").build();
	        return u;
	}

}
