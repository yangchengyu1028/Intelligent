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
 * 采购计划
 * @author ycy
 *
 */
@Entity
@Table(name="bio_buyplan")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuyPlanEntity implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3363360682174101433L;
	private int id;
	private String comName;
	private String spec;
	private String produceFact;
	private String licenseNo;
	private String barCode;
	private String drug;
	private String unit;
	private String erpNo;
	private float evaluate; //预估价格
	private int buyNum; //采购数量
	private float totalPrivce; //总价格
	private String state; //与本地商品库匹配状态
	private UserProductEntity userProduce; //关联本地商品库已关联商品
	private UserBuyPlanEntity userBuyPlan; //关联采购计划
	public BuyPlanEntity() {
		
	}
	public BuyPlanEntity(int id, String comName, String spec, String produceFact, String licenseNo, String barCode,
			String drug, String unit, String erpNo, float evaluate, int buyNum,float totalPrivce, String state, UserProductEntity userProduce,
			UserBuyPlanEntity userBuyPlan) {
		this.id = id;
		this.comName = comName;
		this.spec = spec;
		this.produceFact = produceFact;
		this.licenseNo = licenseNo;
		this.barCode = barCode;
		this.drug = drug;
		this.unit = unit;
		this.erpNo = erpNo;
		this.evaluate = evaluate;
		this.buyNum = buyNum;
		this.totalPrivce = totalPrivce;
		this.state = state;
		this.userProduce = userProduce;
		this.userBuyPlan = userBuyPlan;
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
	@Column(name="comName",length=244)
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	@Column(name="spec",length=244)
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	@Column(name="produceFact",length=244)
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
	@Column(name="barCode",length=244)
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	@Column(name="drug",length=244)
	public String getDrug() {
		return drug;
	}
	public void setDrug(String drug) {
		this.drug = drug;
	}
	@Column(name="unit",length=80)
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	@Column(name="erpNo",length=80)
	public String getErpNo() {
		return erpNo;
	}
	public void setErpNo(String erpNo) {
		this.erpNo = erpNo;
	}
	@Column(name="evaluate",length=80)
	public float getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(float evaluate) {
		this.evaluate = evaluate;
	}
	@Column(name="buyNum")
	public int getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="localGoodsId")
	public UserProductEntity getUserProduce() {
		return userProduce;
	}
	public void setUserProduce(UserProductEntity userProduce) {
		this.userProduce = userProduce;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ubp_id")
	public UserBuyPlanEntity getUserBuyPlan() {
		return userBuyPlan;
	}
	public void setUserBuyPlan(UserBuyPlanEntity userBuyPlan) {
		this.userBuyPlan = userBuyPlan;
	}
	@Column(name="state",length=5)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Column(name="totalPrivce")
	public float getTotalPrivce() {
		return totalPrivce;
	}
	public void setTotalPrivce(float totalPrivce) {
		this.totalPrivce = totalPrivce;
	}
	
	

}
