package com.novo.dto;

import java.util.HashSet;
import java.util.Set;

import com.novo.entity.SupplierEntity;
import com.novo.entity.UserEntity;

public class UserBuySchemeDto {
	
	private int id;
	private UserEntity user;
	private String addTime; //添加时间
	private String subTime; //提交时间
	private int planBuyNum; //计划采购数量
	private int reBuyNum; //实际采购数量
	private float totalPrice; //采购总价格
	private String state; //采购方案状态
	private Set<SupplierEntity> supplier = new HashSet<SupplierEntity>();
	public UserBuySchemeDto() {
		
	}
	public UserBuySchemeDto(int id,UserEntity user, String addTime, String subTime, int planBuyNum, int reBuyNum,
			float totalPrice, String state,Set<SupplierEntity> supplier) {
		this.id = id;
		this.user = user;
		this.addTime = addTime;
		this.subTime = subTime;
		this.planBuyNum = planBuyNum;
		this.reBuyNum = reBuyNum;
		this.totalPrice = totalPrice;
		this.state = state;
		this.supplier = supplier;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public String getSubTime() {
		return subTime;
	}
	public void setSubTime(String subTime) {
		this.subTime = subTime;
	}
	public int getPlanBuyNum() {
		return planBuyNum;
	}
	public void setPlanBuyNum(int planBuyNum) {
		this.planBuyNum = planBuyNum;
	}
	public int getReBuyNum() {
		return reBuyNum;
	}
	public void setReBuyNum(int reBuyNum) {
		this.reBuyNum = reBuyNum;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Set<SupplierEntity> getSupplier() {
		return supplier;
	}
	public void setSupplier(Set<SupplierEntity> supplier) {
		this.supplier = supplier;
	}
}
