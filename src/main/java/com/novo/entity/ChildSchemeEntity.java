package com.novo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 采购子方案(分配到每个供应商的采购方案)
 * @author ycy
 *
 */
@Entity
@Table(name="bio_childscheme")
@JsonIgnoreProperties(ignoreUnknown=true)
public class ChildSchemeEntity implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2821971077009272925L;
	private int id;
	private int buyNum;
	private float price;
	private SupplierEntity supp;
	private UserBuySchemeEntity ubs;
	public ChildSchemeEntity() {
		
	}
	public ChildSchemeEntity(int id, int buyNum, float price, SupplierEntity supp, UserBuySchemeEntity ubs) {
		super();
		this.id = id;
		this.buyNum = buyNum;
		this.price = price;
		this.supp = supp;
		this.ubs = ubs;
	}
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="buyNum")
	public int getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}
	@Column(name="price",length=24)
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="sellerId")
	public SupplierEntity getSupp() {
		return supp;
	}
	public void setSupp(SupplierEntity supp) {
		this.supp = supp;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ubs_id")
	public UserBuySchemeEntity getUbs() {
		return ubs;
	}
	public void setUbs(UserBuySchemeEntity ubs) {
		this.ubs = ubs;
	}
	
	

}
