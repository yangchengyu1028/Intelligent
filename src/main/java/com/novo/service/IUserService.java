package com.novo.service;

import java.util.List;

import com.novo.entity.UserEntity;
import com.novo.util.PageBean;

public interface IUserService {
	
	//查找用户
	public UserEntity findUser(String name,String password) ;
	/**
	 * 得到所有用户	(包含已注销)
	 * @return
	 */
	public List<UserEntity> getAllList();
	/**
	 * 根据供货商名分页查询买家
	 * @param name
	 * @param marryState
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageBean getList(String realName,String state,int pageNo,int pageSize);
	/**
	 * 根据供货商名查询买家总数
	 * @param name
	 * @param marryState
	 * @return
	 */
	public long getTotalNum(String realName,String state);
	/**
	 * 通过id获取实体
	 * @param id
	 * @return
	 */
	public UserEntity getById(int id);
	
	/**
	 * 修改
	 * @param supp
	 */
	public void updata(UserEntity user);
	/**
	 * 保存
	 * @param user
	 */
	public void save(UserEntity user);

}
