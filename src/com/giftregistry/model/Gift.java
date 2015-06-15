package com.giftregistry.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Gift")
public class Gift {
	
	@Id
	@Column(name="GiftID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="GiftName")
	private String name;
	
	@Column(name="PubDate")
	private String pubdate;
	
	@Column(name="Description")
	private String desc;
	
	@Column(name="WhoForID_fk")
	private String whofor;
	
	@Column(name="Price")
	private BigDecimal price;
	
	@Column(name="StoreID_fk")
	private String store;
	
	@Column(name="Status")
	private Boolean status;
	
	@Column(name="BoughtBy")
	private String username;
	
	
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPubdate() {
		return pubdate;
	}

	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getWhofor() {
		return whofor;
	}

	public void setWhofor(String whofor) {
		this.whofor = whofor;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	@Override
	public String toString(){
		return "id="+id+", name="+name+", price="+price+", store="+store+", whofor="+whofor+", status="+status+",username="+username;
	}
	
	
	
	
	

}
