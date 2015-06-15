package com.giftregistry.service;

import java.util.List;

import com.giftregistry.model.*;

public interface GiftService {
	
	public void addGift(Gift g);
	public void updateGift(Gift g);
	public void editGift(Gift g);
	public void buyGift(int id, String username);
	public boolean checkStatus(int id, String username);
	public List<Gift> listGifts();
	public List<Gift> listBothGifts();
	public List<Gift> listStephenGifts();
	public List<Gift> listEricaGifts();
	public List<WhoFor> listWhoFors();
	public List<Store> listStores();
	public List<User> listUsers();
	public Gift getGiftById(int id);
	public void removeGift(int id);

}
