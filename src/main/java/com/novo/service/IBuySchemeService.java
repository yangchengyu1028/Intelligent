package com.novo.service;

import java.util.List;

import com.novo.dto.NoBuyDto;
import com.novo.entity.BuyPlanEntity;
import com.novo.entity.BuySchemeEntity;
import com.novo.entity.PostBuyScheme;
import com.novo.util.PageBean;

public interface IBuySchemeService {
	/**
	 * 分页模糊查询可购买的商品
	 * @param id
	 * @param comName
	 * @param pageNo
	 * @param PageSize
	 * @return
	 */
	public PageBean getList(int id,String comName,int pageNo,int pageSize);
	/**
	 * 得到此子方案下商品总数
	 * @param id
	 * @param comName
	 * @return
	 */
	public long getTotalNum(int id,String comName);
	/**
	 * 通过外键获得集合
	 * @param id
	 * @return
	 */
	public List<BuySchemeEntity> getListById(int id);
	/**
	 * 通过外键获得购买的商品
	 * @param id
	 * @return
	 */
	public List<BuySchemeEntity> getListByIdOfBuy(int id);
	/**
	 * 将采购计划已匹配商品和方案比较，得到未采购商品
	 * @param list1
	 * @param list2
	 * @return
	 */
	public NoBuyDto getNoBuyGoods(List<BuyPlanEntity> list1,List<BuySchemeEntity> list2);
	/**
	 * 通过ID找到此次订单的所有商品
	 * @param id
	 * @return
	 */
	public List<PostBuyScheme> getAllBuyScheme(int id);
	/**
	 * 通过商品货号找到方案中该商品
	 * @param goodsSn
	 * @return
	 */
	public BuySchemeEntity getByGoodsSn(int id);
	/**
	 * 将库存不足的商品实际采购数量和价格设置为0
	 * @param bs
	 */
	public void updata(BuySchemeEntity bs);
	/**
	 * 得到方案中未购买的商品
	 * @param id
	 * @return
	 */
	public List<BuySchemeEntity> getUnpurchased(int id);
}
