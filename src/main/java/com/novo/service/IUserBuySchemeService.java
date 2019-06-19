package com.novo.service;

import java.util.List;

import com.novo.entity.ChildSchemeEntity;
import com.novo.entity.CloudGoodsEntity;
import com.novo.entity.CloudGoodsSupplierEntity;
import com.novo.entity.SupplierEntity;
import com.novo.entity.UserBuyPlanEntity;
import com.novo.entity.UserBuySchemeEntity;
import com.novo.entity.UserEntity;
import com.novo.util.PageBean;

public interface IUserBuySchemeService {
	/**
	 * 分页模糊查询
	 * @param subTime
	 * @param addTime
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageBean getList(String subTime,String addTime,String state,int pageNo,int pageSize,UserEntity user);
	/**
	 * 模糊查询其总条数
	 * @param subTime
	 * @param addTime
	 * @return
	 */
	public long getTotalNum(String subTime,String addTime,String state,UserEntity user);
	/**
	 * 得到已经提交的计划，新建方案
	 * @return
	 */
	public List<UserBuyPlanEntity> getUserBuyPlan(String planTime,String manageTime,UserEntity user);
	/**
	 * 根据采购计划商品对应的云商品和匹配供应商，找出包含该商品的已匹配供应商及各种商品信息
	 * @param list
	 * @return
	 */
	public List<List<CloudGoodsSupplierEntity>> getListOfCloudGoodsSupplier(List<CloudGoodsEntity> list,List<SupplierEntity> list0);
	/**
	 * 提交订单后根据传入数据确认方案并保存到数据库
	 * @param id
	 * @param goodsId
	 * @param supplierId
	 * @param buyNum
	 * @param user
	 */
	public void determineScheme(int id,String[] goodsId,String[] supplierId,String[] buyNum,UserEntity user);
	/**
	 * 分页查询子方案
	 * @param id
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageBean getListOfChildScheme(int id,int pageNo,int pageSize);
	/**
	 * 该方案下子方案数量
	 * @param id
	 * @return
	 */
	public long getTotalNumOfChildScheme(int id);
	/**
	 * 通过Id得到
	 * @param id
	 * @return
	 */
	public UserBuySchemeEntity getById(int id);
	/**
	 * 通过ID删除方案
	 * @param id
	 */
	public void delById(int id);
	/**
	 * 通过实体删除
	 * @param ubs
	 */
	public void delByUBS(UserBuySchemeEntity ubs);
	/**
	 * 得到该用户最近7次的方案(按时间排序)
	 * @param user
	 * @return
	 */
	public List<UserBuySchemeEntity> getListOfINDEX(UserEntity user);
	/**
	 * 根据最新一次方案，查询该方案下的多个子方案
	 * @param ubs
	 * @return
	 */
	public List<ChildSchemeEntity> getListOfChildScheme(UserEntity user);
	/**
	 * 获取最新一次方案
	 * @return
	 */
	public UserBuySchemeEntity getNew(UserEntity user);
	/**
	 * 修改方案状态
	 * @param ubs
	 */
	public void updata(UserBuySchemeEntity ubs);
}
