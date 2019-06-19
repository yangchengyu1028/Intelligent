package com.novo.service;


import java.util.List;

import com.novo.entity.SupplierEntity;
import com.novo.entity.UserEntity;
import com.novo.entity.UserSupplierEntity;
import com.novo.util.PageBean;

public interface IUserSupplierService {
	
	public void save(UserSupplierEntity us);
	
	public Boolean exist(UserEntity user,SupplierEntity supp);
	/**
	 * 更新库存
	 * @param count
	 */
	public void updataOfNum(UserSupplierEntity us);
	/**
	 * 通过用户和商家ID获得实体
	 * @param userId
	 * @param suppId
	 * @return
	 */
	public UserSupplierEntity getUS(int userId,int suppId);
	/**
	 * 分页查询该店铺 已关联的下游买家
	 * @param name
	 * @param sellerState
	 * @param pageNo
	 * @param pageSize
	 * @param entity
	 * @return
	 */
	public PageBean getList(String name,String sellerState,int pageNo,int pageSize,SupplierEntity entity);
	/**
	 * 查询该店铺 已关联的下游买家总数
	 * @param name
	 * @param sellerState
	 * @param entity
	 * @return
	 */
	public long getTotalNum(String name,String sellerState,SupplierEntity entity);
	
	/**
	 * 通过ID找到实体
	 * @param id
	 * @return
	 */
	public UserSupplierEntity getById(int id);
	/**
	 * 修改
	 * @param entity
	 */
	public void update(UserSupplierEntity entity);
	/**
	 * 获取所有
	 * @return
	 */
	public List<UserSupplierEntity> getAll();
	/**
	 * 分页查询该店铺 管理员已绑定的下游买家
	 * @param name
	 * @param sellerState
	 * @param pageNo
	 * @param pageSize
	 * @param supplierId
	 * @return
	 */
	public PageBean getBuyerList(String name,String marryState,int pageNo,int pageSize,int supplierId);
	/**
	 * 查询该店铺管理员已绑定的下游买家总数
	 * @param name
	 * @param sellerState
	 * @param supplierId
	 * @return
	 */
	public long getBuyerTotalNum(String name,String marryState,int supplierId);
	/**
	 * 分页查询该买家 管理员已绑定的上游商家
	 * @param name
	 * @param sellerState
	 * @param pageNo
	 * @param pageSize
	 * @param supplierId
	 * @return
	 */
	public PageBean getSellerList(String name,String marryState,int pageNo,int pageSize,int buyerId);
	/**
	 * 查询该店铺管理员已绑定的上游商家总数
	 * @param name
	 * @param sellerState
	 * @param supplierId
	 * @return
	 */
	public long getSellerTotalNum(String name,String marryState,int buyerId);
}
