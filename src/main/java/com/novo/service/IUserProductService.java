package com.novo.service;

import java.util.List;

import com.novo.entity.UserEntity;
import com.novo.entity.UserProductEntity;
import com.novo.util.PageBean;
import com.novo.vo.GoodsVo;

public interface IUserProductService {
	/**
	 * 根据查询条件分页查询
	 * @param goods 获取多个条件后封装的VO
	 * @param pageNo 当前第几页
	 * @param pageSize 每页的条数
	 * @return
	 */
	public PageBean getList(GoodsVo goods,int pageNo,int pageSize,UserEntity user);
	/**
	 * 根据查询条件查出满足条件的总条数
	 * @param goods 获取多个条件后封装的VO
	 * @return
	 */
	public long getTotalNum(GoodsVo goods,UserEntity user); 
	/**
	 * 增加
	 * @param upd 获取excel表中的实体
	 */
	public void add(UserProductEntity upd);
	/**
	 * 根据传过来的数据修改商品的标记内容
	 * @param checkID 多个需要修改的商品数组
	 * @param radio 修改标记内容
	 */
	public void updateSignError(String[] checkID,String radio);
	/**
	 * 根据传过来的多个商品ID删除商品
	 * @param checkID 多个商品ID的数组
	 */
	public void delUserProduct(String[] checkID);
	/**
	 * 通过ID找到实体
	 * @param id
	 * @return
	 */
	public UserProductEntity getById(int id);
	/**
	 * 根据传过来的对象修改实体
	 * @param upe
	 */
	public void update(UserProductEntity upe);
	/**
	 * 根据实体删除
	 * @param upe
	 */
	public void delete(UserProductEntity upe);
	/**
	 * 查询已关联总数
	 * @return
	 */
	public int getNumOfRele(UserEntity user);
	/**
	 * 查询未关联总数
	 * @return
	 */
	public int getNumOfNoRele(UserEntity user);
	/**
	 * 查询该条本地数据是否已经存在
	 * @param comName
	 * @param spec
	 * @param produceFact
	 * @param licenseNo
	 * @return
	 */
	public UserProductEntity query0(String erpNo,UserEntity user);
	/**
	 * 查询并关联到采购计划
	 * @param comName
	 * @param spec
	 * @param produceFact
	 * @param licenseNo
	 * @return
	 */
	public UserProductEntity query(String erpNo,UserEntity user);
	/**
	 * 得到本地未关联的商品集合
	 * @param user
	 * @return
	 */
	public List<UserProductEntity> getOfNoRele(UserEntity user);
	/**
	 * 根据erpNo编号查询该用户本地库是否存在该商品
	 * @param erpNo
	 * @param user
	 * @return
	 */
	public UserProductEntity exist(String erpNo,UserEntity user);
}
