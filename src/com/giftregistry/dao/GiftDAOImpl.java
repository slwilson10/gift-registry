package com.giftregistry.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;








import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.giftregistry.model.*;

@Repository
public class GiftDAOImpl implements GiftDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(GiftDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addGift(Gift g){
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(g);
		logger.info("Gift saved successfully, Gift Details=" +g);
	}
	
	@Override
	public void updateGift(Gift g){
		Session session = this.sessionFactory.getCurrentSession();
		session.update(g);
		logger.info("Gift updated successfully, Gift Details=" +g);
		
	}
	
	@Override
	public void editGift(Gift g){
		// Retrieve session from Hibernate
		  Session session = this.sessionFactory.getCurrentSession();
		  // Retrieve existing person via i
			
		 
		  // Save updates
		  session.update(g);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Gift> listGifts(String whofor, String store, String price){
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println(whofor);
		System.out.println(store);
		System.out.println(price);
		if (whofor != null){ 
			List<Gift> giftList = session.createQuery("FROM Gift WHERE WhoForID_fk='"+whofor + "'").list();
			return giftList;}
		if (store != null){ 
			List<Gift> giftList = session.createQuery("FROM Gift WHERE StoreID_fk='"+store + "'").list();
			return giftList;}
		if (price != null){ 
			if (price.equals("$")){
				List<Gift> giftList = session.createQuery("FROM Gift WHERE Price < 10").list();
				return giftList;
			}
			if (price.equals("$$")){
				List<Gift> giftList = session.createQuery("FROM Gift WHERE Price Between 10 and 50").list();
				return giftList;
			}
			if (price.equals("$$$")){
				List<Gift> giftList = session.createQuery("FROM Gift WHERE Price > 50").list();
				return giftList;
			}
			else {List<Gift> giftList = session.createQuery("From Gift").list();
			return giftList;}
		}
		else {List<Gift> giftList = session.createQuery("From Gift").list();
			return giftList;}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Gift> listBothGifts(){
		Session session = this.sessionFactory.getCurrentSession();
		List<Gift> giftList = session.createQuery("From Gift Where WhoForID_fk='Both'").list();
		for(Gift g : giftList){
			logger.info("Gift List::" +g);
		}
		return giftList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Gift> listStephenGifts(){
		Session session = this.sessionFactory.getCurrentSession();
		List<Gift> giftList = session.createQuery("From Gift Where WhoForID_fk='Stephen'").list();
		for(Gift g : giftList){
			logger.info("Gift List::" +g);
		}
		return giftList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Gift> listEricaGifts(){
		Session session = this.sessionFactory.getCurrentSession();
		List<Gift> giftList = session.createQuery("From Gift Where WhoForID_fk='Erica'").list();
		for(Gift g : giftList){
			logger.info("Gift List::" +g);
		}
		return giftList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Gift> listBoughtByYou(String curuser){
		System.out.println("Tyhe user is:" +curuser);
		Session session = this.sessionFactory.getCurrentSession();
		List<Gift> giftList = session.createQuery("From Gift Where BoughtBy='"+curuser+"'").list();
		for(Gift g : giftList){
			logger.info("Gift List::" +g);
		}
		return giftList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Store> listStores(){
		Session session = this.sessionFactory.getCurrentSession();
		List<Store> storeList = session.createQuery("From Store").list();
		for(Store s : storeList){
			logger.info("Store List::" + s);
		}
		return storeList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<WhoFor> listWhoFors(){
		Session session = this.sessionFactory.getCurrentSession();
		List<WhoFor> whoforList = session.createQuery("From WhoFor").list();
		for(WhoFor w : whoforList){
			logger.info("WhoFor List::" + w);
		}
		return whoforList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers(){
		Session session = this.sessionFactory.getCurrentSession();
		List<User> userList = session.createQuery("From User").list();
		for(User u : userList){
			logger.info("WhoFor List::" + u);
		}
		return userList;
	}
	
	@Override
	public Gift getGiftById(int id){
		Session session = this.sessionFactory.getCurrentSession();
		Gift g = (Gift) session.load(Gift.class, new Integer(id));
		logger.info("Gift loaded successfully. Gift Details= " + g);
		return g;
		
	}
	@Override
	public void removeGift(int id){
		Session session = this.sessionFactory.getCurrentSession();
		Gift g = (Gift) session.load(Gift.class, new Integer(id));
		if(null != g){
			session.delete(g);
		}
		logger.info("Gift deleted successfully. Gift Details= " + g);
	}
	@Override
	public void buyGift(int id, String username){
		Session session = this.sessionFactory.getCurrentSession();
		Gift g = (Gift) session.load(Gift.class, new Integer(id));
		if(g.getStatus() == false){
			System.out.println("Running if in DAOImpl");
					g.setStatus(true);
					g.setUsername(null);
					session.update(g);
			}else {
				System.out.println("Running else in DAOImpl");
			g.setStatus(false);
			g.setUsername(username);
			System.out.println(username);
			session.update(g);
			}
	}
	
	@Override
	public boolean checkStatus(int id, String username){
		Session session = this.sessionFactory.getCurrentSession();
		Gift g = (Gift) session.load(Gift.class, new Integer(id));
		String msg = g.getUsername();
		Boolean status = g.getStatus();
		System.out.println("Seeing if status is equal to false. It is: " + status);
		if(g.getStatus() == true){
			System.out.println("Seeing if username is equal to username. It is: " + username + "&" + msg);
				return true;
		}else {
			if(msg != null && msg.equals(username)){
				return true;
			}else{
				System.out.println("Username check returning false.");
				return false;
			}
	}}
	

}
