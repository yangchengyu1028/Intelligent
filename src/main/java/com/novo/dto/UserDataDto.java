package com.novo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.novo.entity.BuyPlanEntity;
import com.novo.entity.BuySchemeEntity;
import com.novo.entity.CloudGoodsSupplierEntity;
import com.novo.entity.SupplierEntity;
/**
 * 用于存放采购计划表，采购计划商品集合，和对应匹配的供应商集合
 * @author ycy
 *
 */
import com.novo.entity.UserBuySchemeEntity;
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDataDto implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -291435693108211842L;
	
	private List<BuyPlanEntity> list1; //采购计划所有匹配成功的商品
	private List<SupplierEntity> list2; //该用户已匹配的供应商
	private List<List<CloudGoodsSupplierEntity>>  list3;  //供应商包含的采购计划商品
	public UserDataDto() {
	}
	public UserDataDto(List<List<CloudGoodsSupplierEntity>> list3, List<BuyPlanEntity> list1, List<SupplierEntity> list2) {
		super();
		this.list3 = list3;
		this.list1 = list1;
		this.list2 = list2;
	}
	public List<List<CloudGoodsSupplierEntity>> getList3() {
		return list3;
	}
	public void setList3(List<List<CloudGoodsSupplierEntity>> list3) {
		this.list3 = list3;
	}
	public List<BuyPlanEntity> getList1() {
		return list1;
	}
	public void setList1(List<BuyPlanEntity> list1) {
		this.list1 = list1;
	}
	public List<SupplierEntity> getList2() {
		return list2;
	}
	public void setList2(List<SupplierEntity> list2) {
		this.list2 = list2;
	}
	
}
