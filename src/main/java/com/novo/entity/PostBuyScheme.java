package com.novo.entity;

public class PostBuyScheme {
	private int post_id; //方案中商品id
	private String goods_name;
	private float market_price; //实际采购价格
	private int goods_number;  //实际采购数量
	public PostBuyScheme() {
		
	}
	public PostBuyScheme(int post_id,String goods_name, float market_price, int goods_number) {
		super();
		this.post_id = post_id;
		this.goods_name = goods_name;
		this.market_price = market_price;
		this.goods_number = goods_number;
	}
	
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public float getMarket_price() {
		return market_price;
	}
	public void setMarket_price(float market_price) {
		this.market_price = market_price;
	}
	public int getGoods_number() {
		return goods_number;
	}
	public void setGoods_number(int goods_number) {
		this.goods_number = goods_number;
	}


	
	
}
