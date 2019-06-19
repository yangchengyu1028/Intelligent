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
 * 供应商总商品表
 * @author ycy
 *
 */
@Entity
@Table(name = "bio_product")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CloudGoodsSupplierEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5227084541165569943L;

	private int id;
	private SupplierEntity supp;
	private CloudGoodsEntity goods;
	private int stock; //库存
	private String price; //价格
	private String expiryDate; //效期
	private String expiration_date; //有效期（时间段）
	private String productiontime;  //生产日期
	private String goods_packing;//包装
	private String comName; // 通用名
	private String spec; // 规格
	private String produceFact; // 生产厂家
	private String licenseNo; // 批准文号
	private String barCode; // 条形码
	private String updatePrice; //主动修改的价格，不为9999.00则采用该价格为出售价格
	private int basicState;//与基本库绑定状态，0为未绑定，1为绑定
	private String sellerProId;//卖家产品自编码
	private int state;//产品是否可售，0为不可售，1为可售
	public CloudGoodsSupplierEntity() {
		
	}
	
	
	public CloudGoodsSupplierEntity(int id, SupplierEntity supp, CloudGoodsEntity goods, int stock, String price,String expiryDate,String expiration_date,String productiontime,String goods_packing
			,String comName,String spec,String produceFact,String licenseNo,String barCode,String updatePrice,int basicState,String sellerProId,int state) {
		super();
		this.id = id;
		this.supp = supp;
		this.goods = goods;
		this.stock = stock;
		this.price = price;
		this.expiration_date = expiration_date;
		this.productiontime = productiontime;
		this.goods_packing = goods_packing;
		this.comName = comName;
		this.spec = spec;
		this.price = price;
		this.produceFact = produceFact;
		this.licenseNo = licenseNo;
		this.barCode = barCode;
		this.updatePrice = updatePrice;
		this.basicState = basicState;
		this.sellerProId = sellerProId;
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
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="sellerId")
	public SupplierEntity getSupp() {
		return supp;
	}
	public void setSupp(SupplierEntity supp) {
		this.supp = supp;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="basicGoodsId")
	public CloudGoodsEntity getGoods() {
		return goods;
	}

	public void setGoods(CloudGoodsEntity goods) {
		this.goods = goods;
	}
	
	@Column(name="stock")
	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}

	@Column(name="price")
	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}

	@Column(name="expiryDate")
	public String getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Column(name="expiration_date",columnDefinition="varchar(128) default '99999'")
	public String getExpiration_date() {
		return expiration_date;
	}
	public void setExpiration_date(String expiration_date) {
		this.expiration_date = expiration_date;
	}
	@Column(name="productiontime",columnDefinition="varchar(128) default '99999'")
	public String getProductiontime() {
		return productiontime;
	}
	public void setProductiontime(String productiontime) {
		this.productiontime = productiontime;
	}
	@Column(name="goods_packing",columnDefinition="varchar(10) default '1'")
	public String getGoods_packing() {
		return goods_packing;
	}
	public void setGoods_packing(String goods_packing) {
		this.goods_packing = goods_packing;
	}

	@Column(name="comName")
	public String getComName() {
		return comName;
	}


	public void setComName(String comName) {
		this.comName = comName;
	}

	@Column(name="spec")
	public String getSpec() {
		return spec;
	}


	public void setSpec(String spec) {
		this.spec = spec;
	}

	@Column(name="produceFact")
	public String getProduceFact() {
		return produceFact;
	}


	public void setProduceFact(String produceFact) {
		this.produceFact = produceFact;
	}

	@Column(name="licenseNo")
	public String getLicenseNo() {
		return licenseNo;
	}


	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	@Column(name="barCode")
	public String getBarCode() {
		return barCode;
	}


	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	@Column(name="updatePrice")
	public String getUpdatePrice() {
		return updatePrice;
	}


	public void setUpdatePrice(String updatePrice) {
		this.updatePrice = updatePrice;
	}

	@Column(name="basicState")
	public int getBasicState() {
		return basicState;
	}


	public void setBasicState(int basicState) {
		this.basicState = basicState;
	}

	@Column(name="sellerProId")
	public String getSellerProId() {
		return sellerProId;
	}


	public void setSellerProId(String sellerProId) {
		this.sellerProId = sellerProId;
	}

	@Column(name="state",columnDefinition="int(10) default '1'")
	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}
	
	
	
	
	
}
