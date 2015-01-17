package com.ppro.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppro.spring.dao.AbstractDAO;
import com.ppro.spring.dao.UserDAO;
import com.ppro.spring.model.User;
import com.ppro.spring.service.api.UserService;

/**
 * Created with IntelliJ IDEA.
 * User: lukas
 * Date: 4.1.15
 */
@Service
public class UserServiceImpl extends AbstractCRUDService<User> implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	protected AbstractDAO<User> getDAOInstance() {
		return userDAO;
	}

	@Override
	public User getUserByName(String name) {
		return userDAO.getByName(name);
	}
}
