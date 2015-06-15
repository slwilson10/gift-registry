package com.giftregistry.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.giftregistry.model.*;

@Repository
public class UserDAOImpl implements UserDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	
	@Override
	public void addUser(User u){
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(u);
		
		logger.info("User saved successfully, User Details=" +u);
	}
	
	@Override
	public void addUserRole(User_Roles r){
		Session session = this.sessionFactory.getCurrentSession();
		User_Roles user = new User_Roles();
		user.setUsername(r.getUsername()); 
		user.setRole("ROLE_USER");
		
		session.persist(user);
		
		logger.info("User saved successfully, User Details=" +r);
	}
}
