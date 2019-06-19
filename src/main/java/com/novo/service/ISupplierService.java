package com.novo.service;

import java.util.List;

import com.novo.entity.SupplierEntity;
import com.novo.entity.UserEntity;
import com.novo.entity.UserSupplierEntity;
import com.novo.util.PageBean;

public interface ISupplierService {
	/**
	 * 根据供货商名和关联状态进行分页查询
	 * @param name
	 * @param marryState
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageBean getList(String name,String buyerState,int pageNo,int pageSize,UserEntity user);
	/**
	 * 根据供货商名和关联状态查询供货商总数
	 * @param name
	 * @param marryState
	 * @return
	 */
	public long getTotalNum(String name,String buyerState,UserEntity user);
	/**
	 * 通过ID查找供应商实体
	 * @param id
	 * @return
	 */
	public UserSupplierEntity getById(int id,UserEntity user);
	/**
	 * 通过实体对象修改供应商实体
	 * @param se
	 */
	public void updateOfState(UserSupplierEntity us);
	/**
	 * 查询该用户已关联的供应商
	 * @param user
	 * @return
	 */
	public List<UserSupplierEntity> getListOfRe(UserEntity user);
	/**
	 * 查询该用户未关联的供应商
	 * @param user
	 * @return
	 */
	public List<UserSupplierEntity> getListOfNoRe(String name,UserEntity user);
	/**
	 * 查询该用户已匹配的供应商总数
	 * @param user
	 * @return
	 */
	public int getNumOfsupp(UserEntity user);
	
	public void save(SupplierEntity supp);
	/**
	 * 判断数据库是否存在
	 * @param name
	 * @return 
	 */
	public Boolean exist(int id);
	/**
	 * 得到所有供应商
	 * @return
	 */
	public List<SupplierEntity> getAll();
	/**
	 * 通过ID找到实体
	 * @param id
	 * @return
	 */
	public SupplierEntity getById(int id);
	/**
	 * 该用户的商家
	 * @param id
	 * @return
	 */
	public List<UserSupplierEntity> list(int id);
	/**
	 * 修改
	 * @param supp
	 */
	public void updata(SupplierEntity supp);
	/**
	 * 查询
	 * @param name
	 * @param mobile
	 * @return
	 */
	public SupplierEntity getByNameAndMobile(String name,String mobile);
	/**
	 * 根据供货商名分页查询已经入驻商家
	 * @param name
	 * @param marryState
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageBean getList(String name,String state,int pageNo,int pageSize);
	/**
	 * 根据供货商名查询已入驻商家总数
	 * @param name
	 * @param marryState
	 * @return
	 */
	public long getTotalNum(String name,String state);
}
