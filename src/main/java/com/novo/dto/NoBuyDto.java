package com.novo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * 存放未采购商品的实体
 * @author it-10
 *
 */
import com.novo.entity.BuyPlanEntity;
@JsonIgnoreProperties(ignoreUnknown = true)
public class NoBuyDto implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8005562994713293918L;
	private List<BuyPlanEntity> list1; 
	private List<Integer> list2;
	public NoBuyDto() {
	
	}
	public NoBuyDto(List<BuyPlanEntity> list1, List<Integer> list2) {
		super();
		this.list1 = list1;
		this.list2 = list2;
	}
	public List<BuyPlanEntity> getList1() {
		return list1;
	}
	public void setList1(List<BuyPlanEntity> list1) {
		this.list1 = list1;
	}
	public List<Integer> getList2() {
		return list2;
	}
	public void setList2(List<Integer> list2) {
		this.list2 = list2;
	}
	
}
