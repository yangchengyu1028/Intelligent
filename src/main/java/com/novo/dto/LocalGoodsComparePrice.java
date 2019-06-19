package com.novo.dto;

import java.util.List;

import com.novo.entity.CloudGoodsSupplierEntity;
import com.novo.entity.SupplierEntity;
import com.novo.entity.UserProductEntity;

public class LocalGoodsComparePrice {

	private UserProductEntity userProductEntity;
	private List<SupplierEntity> list1;
	private List<CloudGoodsSupplierEntity> list2;
	public LocalGoodsComparePrice() {
	}
	public LocalGoodsComparePrice(UserProductEntity userProductEntity, List<SupplierEntity> list1,
			List<CloudGoodsSupplierEntity> list2) {
		super();
		this.userProductEntity = userProductEntity;
		this.list1 = list1;
		this.list2 = list2;
	}
	public UserProductEntity getUserProductEntity() {
		return userProductEntity;
	}
	public void setUserProductEntity(UserProductEntity userProductEntity) {
		this.userProductEntity = userProductEntity;
	}
	public List<SupplierEntity> getList1() {
		return list1;
	}
	public void setList1(List<SupplierEntity> list1) {
		this.list1 = list1;
	}
	public List<CloudGoodsSupplierEntity> getList2() {
		return list2;
	}
	public void setList2(List<CloudGoodsSupplierEntity> list2) {
		this.list2 = list2;
	}
	
	
}
