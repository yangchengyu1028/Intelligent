package com.novo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 管理员
 * @author yangchengyu
 *
 */
@Entity
@Table(name="bio_admin")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 116653544800901291L;
	private int id;
	private String name;
	private String password;
	
	public AdminEntity() {

	}

	public AdminEntity(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
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
	@Column(name="name",length=24)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name="password",length=24)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
