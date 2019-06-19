package com.novo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * 云商品库商品
 * @author ycy
 *
 */
@Entity
@Table(name="bio_basicgoods")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CloudGoodsEntity implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9008993120070372L;

	private int id;//主键
	private String comName; // 通用名
	private String spec; // 规格
	private String produceFact; // 生产厂家
	private String licenseNo; // 批准文号
	private String barCode; // 条形码
	private String specDroduct;//规格乘积
	private String pronum;//基础库id
	public CloudGoodsEntity() {
		
	}

	public CloudGoodsEntity(int id, String comName, String spec, String produceFact, String licenseNo, String barCode,
			String specDroduct,String pronum ) {
		this.id = id;
		this.comName = comName;
		this.spec = spec;
		this.produceFact = produceFact;
		this.licenseNo = licenseNo;
		this.barCode = barCode;
		this.specDroduct = specDroduct;
		this.pronum = pronum;
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
	@Column(name="comName",length=80)
	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}
	@Column(name="spec",length=80)
	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}
	@Column(name="productFact",length=244)
	public String getProduceFact() {
		return produceFact;
	}

	public void setProduceFact(String produceFact) {
		this.produceFact = produceFact;
	}
	@Column(name="licenseNo",length=80)
	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	@Column(name="barCode",length=80)
	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	@Column(name="specDroduct",length=40)
	public String getSpecDroduct() {
		return specDroduct;
	}

	public void setSpecDroduct(String specDroduct) {
		this.specDroduct = specDroduct;
	}

	@Column(name="pronum",length=100)
	public String getPronum() {
		return pronum;
	}

	public void setPronum(String pronum) {
		this.pronum = pronum;
	}
}
