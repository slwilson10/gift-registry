package com.giftregistry.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.giftregistry.model.*;
import com.giftregistry.dao.UserDAO;


@Service
public class UserServiceImpl implements UserService  {
	
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO){
		this.userDAO = userDAO;
	}
	
	@Override
	@Transactional
	public void addUser(User u){
		this.userDAO.addUser(u);
	}
	
	@Override
	@Transactional
	public void addUserRole(User_Roles r){
		this.userDAO.addUserRole(r);
	}
	

}
