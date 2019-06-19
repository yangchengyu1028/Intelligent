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
 * 本地商品关联库
 * @author ycy
 *
 */
@Entity
@Table(name = "bio_localgoods")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProductEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7786906505045265373L;
	private int id;
	private String comName; // 通用名
	private String spec; // 规格
	private String produceFact; // 生产厂家
	private String licenseNo; // 批准文号
	private String barCode; // 条形码
	private String drug; // 剂量
	private String erpNo; // erp编号  
	private String unit; // 单位
	private UserEntity user;
	private String relaState; // 关联状态
	private String madeTime; // 修改时间
	private String relaTime; // 关联时间	
	private String signError;// 标记错误数据
	private CloudGoodsEntity goods;

	

	public UserProductEntity() {
	
	}

	public UserProductEntity(int id, String comName, String spec, String produceFact, String licenseNo,
			String barCode, String drug, String erpNo, String unit, UserEntity user, String relaState,
			String madeTime, String relaTime, String signError, CloudGoodsEntity goods) {
		this.id = id;
		this.comName = comName;
		this.spec = spec;
		this.produceFact = produceFact;
		this.licenseNo = licenseNo;
		this.barCode = barCode;
		this.drug = drug;
		this.erpNo = erpNo;
		this.unit = unit;
		this.user = user;
		this.relaState = relaState;
		this.madeTime = madeTime;
		this.relaTime = relaTime;
		this.signError = signError;
		this.goods = goods;
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

	@Column(name = "comName",length=244)
	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	@Column(name = "spec",length=80)
	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	@Column(name = "produceFact",length=244)
	public String getProduceFact() {
		return produceFact;
	}

	public void setProduceFact(String produceFact) {
		this.produceFact = produceFact;
	}

	@Column(name = "licenseNo",length=80)
	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	@Column(name = "barCode",length=80)
	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	@Column(name = "drug",length=80)
	public String getDrug() {
		return drug;
	}

	public void setDrug(String drug) {
		this.drug = drug;
	}

	@Column(name = "erpNo",length=80)
	public String getErpNo() {
		return erpNo;
	}

	public void setErpNo(String erpNo) {
		this.erpNo = erpNo;
	}

	@Column(name = "unit",length=8)
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "buyId")
	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@Column(name = "relaState")
	public String getRelaState() {
		return relaState;
	}

	public void setRelaState(String relaState) {
		this.relaState = relaState;
	}

	@Column(name = "madeTime")
	public String getMadeTime() {
		return madeTime;
	}

	public void setMadeTime(String madeTime) {
		this.madeTime = madeTime;
	}

	@Column(name = "relaTime")
	public String getRelaTime() {
		return relaTime;
	}

	public void setRelaTime(String relaTime) {
		this.relaTime = relaTime;
	}

	@Column(name = "signError",length=24)
	public String getSignError() {
		return signError;
	}

	public void setSignError(String signError) {
		this.signError = signError;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "basicGoodsId")
	public CloudGoodsEntity getGoods() {
		return goods;
	}

	public void setGoods(CloudGoodsEntity goods) {
		this.goods = goods;
	}
	
}
