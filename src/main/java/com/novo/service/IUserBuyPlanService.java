package com.novo.service;

import com.novo.entity.UserBuyPlanEntity;
import com.novo.entity.UserEntity;
import com.novo.util.PageBean;

public interface IUserBuyPlanService {
	/**
	 * 分页模糊查询
	 * @param planTime
	 * @param manageTime
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageBean getList(String planTime,String manageTime,String state,int pageNo,int pageSize,UserEntity user);
	/**
	 * 模糊查询其总条数
	 * @param planTime
	 * @param manageTime
	 * @return
	 */
	public long getTotalNum(String planTime,String manageTime,String state,UserEntity user);
	/**
	 * 添加
	 * @param ubp
	 */
	public void save(UserBuyPlanEntity ubp);
	/**
	 * 查询单个
	 * @param planTime
	 * @return
	 */
	public UserBuyPlanEntity query(String planTime,UserEntity user);
	/**
	 * 修改
	 * @param ubp
	 */
	public void update(UserBuyPlanEntity ubp);
	/**
	 * 通过id查询
	 * @param id
	 * @return
	 */
	public UserBuyPlanEntity getById(int id);
	/**
	 * 删除
	 * @param id
	 */
	public void delete(UserBuyPlanEntity ubp);
}
