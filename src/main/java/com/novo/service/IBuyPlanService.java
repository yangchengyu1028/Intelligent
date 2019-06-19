package com.novo.service;

import java.util.List;

import com.novo.entity.BuyPlanEntity;
import com.novo.util.PageBean;

public interface IBuyPlanService {
	/**
	 * 添加保存
	 * @param bp
	 */
	public void save(BuyPlanEntity bp);
	/**
	 * 分页模糊查询所有
	 * @param comName
	 * @param state
	 * @param id
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageBean getList(String comName,String state,int id,int pageNo,int pageSize);
	/**
	 * 查询总数
	 * @param comName
	 * @param state
	 * @param id
	 * @return
	 */
	public long getTotalNum(String comName,String state,int id);
	/**
	 * 通过外键得到list
	 * @param id
	 * @return
	 */
	public List<BuyPlanEntity> getListById(int id);
	/**
	 * 删除
	 * @param bp
	 */
	public void delete(BuyPlanEntity bp);
	/**
	 * 根据ID得到采购计划中已匹配的商品集合
	 * @param id
	 * @return
	 */
	public List<BuyPlanEntity> getListOfRe(int id);
	/**
	 * 根据ID得到采购计划中未匹配的商品集合
	 * @param id
	 * @return
	 */
	public List<BuyPlanEntity> getListOfNoRe(int id);
}
