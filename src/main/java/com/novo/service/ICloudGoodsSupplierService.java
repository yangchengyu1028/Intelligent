package com.novo.service;


import java.util.List;

import com.novo.entity.CloudGoodsEntity;
import com.novo.entity.CloudGoodsSupplierEntity;
import com.novo.entity.SupplierEntity;
import com.novo.entity.UserEntity;
import com.novo.util.PageBean;
import com.novo.vo.AllProductVo;
import com.novo.vo.ProductVo;

public interface ICloudGoodsSupplierService {
	/**
	 * 判断数据库是否存在该数据
	 * @param cgs
	 * @return
	 */
	public CloudGoodsSupplierEntity exist(CloudGoodsSupplierEntity cgs);
	/**
	 * 若不存在则插入
	 * @param cgs
	 */
	public void save(CloudGoodsSupplierEntity cgs);
	/**
	 * 修改
	 * @param cgs
	 */
	public void update(CloudGoodsSupplierEntity cgs);
	/**
	 * 得到该供应商的商品总数
	 * @param supp
	 * @return
	 */
	public int getAllNum(SupplierEntity supp);
	
	/**
	 * 根据查询条件分页查询某个店铺
	 * @param goods 获取多个条件后封装的VO
	 * @param pageNo 当前第几页
	 * @param pageSize 每页的条数
	 * @return
	 */
	public PageBean getList(ProductVo goods,int pageNo,int pageSize,SupplierEntity supplier);
	
	/**
	 * 根据查询条件查出满足条件的总条数
	 * @param goods 获取多个条件后封装的VO
	 * @return
	 */
	public long getTotalNum(ProductVo goods,SupplierEntity supplier); 
	/**
	 * 通过id得到实体
	 * @param id
	 * @return
	 */
	public CloudGoodsSupplierEntity getById(int id);
	
	/**
	 * 根据查询条件分页查询所有店铺商品
	 * @param goods 获取多个条件后封装的VO
	 * @param pageNo 当前第几页
	 * @param pageSize 每页的条数
	 * @return
	 */
	public PageBean getAllList(AllProductVo goods,int pageNo,int pageSize);
	
	/**
	 * 根据查询条件查出满足条件的总条数
	 * @param goods 获取多个条件后封装的VO
	 * @return
	 */
	public long getAllTotalNum(AllProductVo goods); 
	/**
	 * 根据基础库商品和商家集合，查出这些商家下的该商品集合
	 * @param entity
	 * @param list
	 * @return
	 */
	public List<CloudGoodsSupplierEntity> getBySuppAndCloudGoods(CloudGoodsEntity entity,List<SupplierEntity> list);
	/**
	 * 通过商家和商家内部商品自编码找到产品库该产品
	 * @param sellerProId
	 * @param supp
	 * @return
	 */
	public CloudGoodsSupplierEntity getBysellerProIdAndSupplier(String sellerProId,SupplierEntity supp);
}
