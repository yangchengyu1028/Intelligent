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
 * 用户供应商中间表
 * @author ycy
 *
 */
@Entity
@Table(name="bio_buyandsell")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserSupplierEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 692202653978216267L;
	private int id;
	private UserEntity user;
	private SupplierEntity supplier;
	private int count;
	private String marryState;//管理买家卖家是否绑定。0为未绑定1为绑定
	private int sellerState;//卖家对买家可见状态，1为可见，为不可见
	private int buyerState;//买家对卖家绑定状态，0为未绑定，1为绑定
	public UserSupplierEntity() {
	}
	public UserSupplierEntity(int id,String marryState, UserEntity user, SupplierEntity supplier,int count,int sellerState,int buyerState) {
		this.id = id;
		this.marryState = marryState;
		this.user = user;
		this.supplier = supplier;
		this.count = count;
		this.sellerState = sellerState;
		this.buyerState = buyerState;
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
	@Column(name="marryState",columnDefinition="varchar(10) default '0'")
	public String getMarryState() {
		return marryState;
	}
	public void setMarryState(String marryState) {
		this.marryState = marryState;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="buyId")
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="sellerId")
	public SupplierEntity getSupplier() {
		return supplier;
	}
	public void setSupplier(SupplierEntity supplier) {
		this.supplier = supplier;
	}
	@Column(name="goodsNum")
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Column(name="sellerState",columnDefinition="int(10) default '1'")
	public int getSellerState() {
		return sellerState;
	}
	public void setSellerState(int sellerState) {
		this.sellerState = sellerState;
	}
	@Column(name="buyerState",columnDefinition="int(10) default '0'")
	public int getBuyerState() {
		return buyerState;
	}
	public void setBuyerState(int buyerState) {
		this.buyerState = buyerState;
	}
	
	
}
