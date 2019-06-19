package com.novo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * 供应商
 * @author ycy
 *
 */
@Entity
@Table(name="bio_seller")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SupplierEntity implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4745230367001928225L;
	private int id;
	private String name;//供货商名称
	private String mobile;//手机号
	private String state;//账号状态
	private Set<UserBuySchemeEntity> ubs = new HashSet<UserBuySchemeEntity>();
	
	
	
	public SupplierEntity() {
	}
	
	
	public SupplierEntity(int id, String name, String mobile, String rate,Set<UserBuySchemeEntity> ubs,UserEntity user) {
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.ubs = ubs;
	}

	@Column(name="state",columnDefinition="varchar(10) default '1'")
	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
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
	@Column(name="name",length=100)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="mobile",length=11)
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	@ManyToMany(mappedBy = "supplier")
	@JsonIgnore
	public Set<UserBuySchemeEntity> getUbs() {
		return ubs;
	}


	public void setUbs(Set<UserBuySchemeEntity> ubs) {
		this.ubs = ubs;
	}

	
}
