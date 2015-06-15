package com.giftregistry.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.giftregistry.model.*;
import com.giftregistry.dao.GiftDAO;

@Service
public class GiftServiceImpl implements GiftService{
	
	private GiftDAO giftDAO;
	
	public void setGiftDAO(GiftDAO giftDAO){
		this.giftDAO = giftDAO;
	}
	
	@Override
	@Transactional
	public void addGift(Gift g){
		this.giftDAO.addGift(g);
	}
	@Override
	@Transactional
	public void updateGift(Gift g){
		this.giftDAO.updateGift(g);
		
	}
	
	@Override
	@Transactional
	public void editGift(Gift g){
		this.giftDAO.editGift(g);
		
	}
	
	
	@Override
	@Transactional
	public List<Gift> listGifts(){
		return this.giftDAO.listGifts();

	}
	
	@Override
	@Transactional
	public List<Gift> listBothGifts(){
		return this.giftDAO.listBothGifts();

	}
	
	
	@Override
	@Transactional
	public List<Gift> listStephenGifts(){
		return this.giftDAO.listStephenGifts();

	}
	
	
	@Override
	@Transactional
	public List<Gift> listEricaGifts(){
		return this.giftDAO.listEricaGifts();

	}
	
	
	@Override
	@Transactional
	public List<WhoFor> listWhoFors(){
		return this.giftDAO.listWhoFors();

	}
	
	@Override
	@Transactional
	public List<Store> listStores(){
		return this.giftDAO.listStores();

	}
	
	@Override
	@Transactional
	public List<User> listUsers(){
		return this.giftDAO.listUsers();

	}
	
	
	@Override
	@Transactional
	public Gift getGiftById(int id){
		return this.giftDAO.getGiftById(id);
		
	}
	@Override
	@Transactional
	public void removeGift(int id){
		this.giftDAO.removeGift(id);
	}
	@Override
	@Transactional
	public void buyGift(int id, String username){
		this.giftDAO.buyGift(id, username);
	}
	
	@Override
	@Transactional
	public boolean checkStatus(int id, String username){
		return this.giftDAO.checkStatus(id, username);
	}


}
