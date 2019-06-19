package com.novo.vo;

public class AllProductVo {

	/**
	 * 获取页面上传来的商品属性，封装成VO
	 */
	private String comName; //通用名
	private String spec; //规格
	private String produceFact; //生产厂家
	private String licenseNo; //批准文号
	private String sellerProId; //erp编号
	private String supplierName;
	
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
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
	
	
	public String getSellerProId() {
		return sellerProId;
	}
	public void setSellerProId(String sellerProId) {
		this.sellerProId = sellerProId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	private String state; //可售状态
}
