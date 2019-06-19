package com.novo.service;

import java.util.List;

import com.novo.entity.BuyPlanEntity;
import com.novo.entity.CloudGoodsEntity;
import com.novo.entity.CloudGoodsSupplierEntity;
import com.novo.entity.UserProductEntity;

public interface ICloudGoodsService {
	/**
	 * 进行关联操作时，查询对应云商品
	 * @param list
	 * @return
	 */
	public List<CloudGoodsEntity> query(List<String> list);
	
	public CloudGoodsEntity getById(int id);
	/**
	 * 查询预关联的云商品
	 * @param list
	 * @return
	 */
	public List<CloudGoodsEntity> ready(List<String> list);
	/**
	 * 根据采购计划已匹配的商品查询对应的云商品库商品
	 * @param list
	 * @return
	 */
	public List<CloudGoodsEntity> getList(List<BuyPlanEntity> list);
	/**
	 * 导入本地商品excel进行关联操作(规格数字乘积)
	 * @param up
	 * @return
	 */
	public CloudGoodsEntity relevance(UserProductEntity up);
	/**
	 * 导入本地商品excel进行关联操作(三字段全值相等)
	 * @param up
	 * @return
	 */
	public CloudGoodsEntity relevanceByQuanZhi(UserProductEntity up);
	/**
	 * 添加
	 * @param cg
	 */
	public void save(CloudGoodsEntity cg);
	/**
	 * 修改
	 * @param cg
	 */
	public void updata(CloudGoodsEntity cg);
	/**
	 * 获取最近一次修改时间的商品
	 * @return
	 */
	public Object getLastTime();
	/**
	 * 急加载
	 * @param id
	 * @return
	 */
	public CloudGoodsEntity getByID(int id);
	/**
	 * 按时间排序获取单个
	 * @return
	 */
	public List<CloudGoodsEntity> get(int i);

	/**
	 * 通过pronum查询唯一
	 * @param pronum
	 * @return
	 */
	CloudGoodsEntity getByPronum(String pronum);
	/**
	 * 通过licenseNo,specDroduct查询唯一
	 * @param pronum
	 * @return
	 */
	CloudGoodsEntity getByLicenseNo(String licenseNo,String specDroduct);
	/**
	 * 通过comName,spec,produceFact查询唯一
	 * @param pronum
	 * @return
	 */
	CloudGoodsEntity getByThree(CloudGoodsSupplierEntity cloudGoodsSupplierEntity);
	
}
