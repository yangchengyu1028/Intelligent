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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * 采购计划商品
 * @author ycy
 *
 */
@Entity
@Table(name="bio_userbuyplan")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserBuyPlanEntity implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8178765070710495244L;
	private int id;
	private String name;
	private UserEntity user;
	private String planTime;
	private String manageTime;
	private float totalPrice;
	private String state;
	private int totalGoods;
	public UserBuyPlanEntity() {
		
	}
	public UserBuyPlanEntity(int id, String name,UserEntity user, String planTime, String manageTime, float totalPrice, String state,
			int totalGoods) {
		this.id = id;
		this.name = name;
		this.user = user;
		this.planTime = planTime;
		this.manageTime = manageTime;
		this.totalPrice = totalPrice;
		this.state = state;
		this.totalGoods = totalGoods;
	}
	@Id
	@Column(name="id",unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="name",length=244)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "buyerId")
	
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	@Column(name="planTime",length=80)
	public String getPlanTime() {
		return planTime;
	}
	public void setPlanTime(String planTime) {
		this.planTime = planTime;
	}
	@Column(name="manageTime",length=80)
	public String getManageTime() {
		return manageTime;
	}
	public void setManageTime(String manageTime) {
		this.manageTime = manageTime;
	}
	@Column(name="totalPrice")
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Column(name="state",length=8)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Column(name="totalGoods")
	public int getTotalGoods() {
		return totalGoods;
	}
	public void setTotalGoods(int totalGoods) {
		this.totalGoods = totalGoods;
	}
	
	
	
}
