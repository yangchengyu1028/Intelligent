package com.novo.vo;

public class GoodsVo {
	/**
	 * 获取页面上传来的商品属性，封装成VO
	 */
	private String comName; //通用名
	private String spec; //规格
	private String produceFact; //生产厂家
	private String licenseNo; //批准文号
	private String barCode; //条形码
	private String drug; //剂量
	private String erpNo; //erp编号
	private String signError;//标记错误数据
	private String relaState; //关联状态
	
	public String getRelaState() {
		return relaState;
	}
	public void setRelaState(String relaState) {
		this.relaState = relaState;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getProduceFact() {
		return produceFact;
	}
	public void setProduceFact(String produceFact) {
		this.produceFact = produceFact;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public String getDrug() {
		return drug;
	}
	public void setDrug(String drug) {
		this.drug = drug;
	}
	public String getErpNo() {
		return erpNo;
	}
	public void setErpNo(String erpNo) {
		this.erpNo = erpNo;
	}
	public String getSignError() {
		return signError;
	}
	public void setSignError(String signError) {
		this.signError = signError;
	}
	
	
}
