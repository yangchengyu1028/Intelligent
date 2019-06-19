package com.novo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novo.dao.BuyPlanDao;
import com.novo.dao.BuySchemeDao;
import com.novo.dao.ChildSchemeDao;
import com.novo.dao.CloudGoodsSupplierDao;
import com.novo.dao.SupplierDao;
import com.novo.dao.UserBuyPlanDao;
import com.novo.dao.UserBuySchemeDao;
import com.novo.entity.BuyPlanEntity;
import com.novo.entity.BuySchemeEntity;
import com.novo.entity.ChildSchemeEntity;
import com.novo.entity.CloudGoodsEntity;
import com.novo.entity.CloudGoodsSupplierEntity;
import com.novo.entity.SupplierEntity;
import com.novo.entity.UserBuyPlanEntity;
import com.novo.entity.UserBuySchemeEntity;
import com.novo.entity.UserEntity;
import com.novo.service.IUserBuySchemeService;
import com.novo.util.DateToString;
import com.novo.util.PageBean;
@Service("userBuySchemeService")
public class UserBuySchemeServiceImpl implements IUserBuySchemeService {
	
	@Autowired
	private UserBuySchemeDao userBuySchemeDao;
	@Autowired
	private UserBuyPlanDao userBuyPlanDao;
	@Autowired
	private CloudGoodsSupplierDao cloudGoodsSupplierDao;
	@Autowired
	private SupplierDao supplierDao;
	@Autowired
	private ChildSchemeDao childSchemeDao;
	@Autowired
	private BuyPlanDao buyPlanDao;
	@Autowired
	private BuySchemeDao buySchemeDao;
	
	@Override
	public PageBean getList(String subTime, String addTime, String state, int pageNo, int pageSize, UserEntity user) {
		int totalNum = (int) getTotalNum(subTime,addTime,state,user);
		PageBean pb = new PageBean(pageNo, pageSize, totalNum);
		List<String> list = new ArrayList<String>();
		String hql = "from UserBuySchemeEntity ubs where 1=1 ";
		if(subTime != null && !"".equals(subTime)) {
			hql += " and ubs.subTime >= ? ";
			list.add(subTime);
		}
		if(addTime != null && !"".equals(addTime)) {
			hql += " and ubs.addTime >= ? ";
			list.add(addTime);
		}
		if(state != null && !"".equals(state)) {
			hql += " and ubs.state = ? ";
			list.add(state);
		}
		hql += "and ubs.user.id="+user.getId()+"ORDER BY ubs.subTime DESC";
		List<UserBuySchemeEntity> list1 = userBuySchemeDao.getListPageObject(hql, list, pb.getNum(), pageSize);
		pb.setList(list1);
		return pb;
	}

	@Override
	public long getTotalNum(String subTime, String addTime, String state, UserEntity user) {
		List<String> list = new ArrayList<String>();
		String hql = "select count(*) from UserBuySchemeEntity ubs where 1=1 ";
		if(subTime != null&&!"".equals(subTime)) {
			hql += " and ubs.subTime >= ? ";
			list.add(subTime);
		}
		if(addTime != null&&!"".equals(addTime)) {
			hql += " and ubs.addTime >= ? ";
			list.add(addTime);
		}
		if(state != null&&!"".equals(state)) {
			hql += " and ubs.state = ? ";
			list.add(state);
		}
		hql += "and ubs.user.id="+user.getId();
		return userBuySchemeDao.getListAllNums(hql, list);
	}

	@Override
	public List<UserBuyPlanEntity> getUserBuyPlan(String planTime,String manageTime,UserEntity user) {
		List<String> list = new ArrayList<String>();
		String hql = "from UserBuyPlanEntity ubp where ubp.state = '1' and ubp.user.id="+user.getId();
		if(planTime != null&&!"".equals(planTime)) {
			hql += " and ubp.planTime >= ? ";
			list.add(planTime);
		}
		if(manageTime != null&&!"".equals(manageTime)) {
			hql += " and ubp.manageTime >= ? ";
			list.add(manageTime);
		}
		List<UserBuyPlanEntity> list1 = userBuyPlanDao.getListObject(hql, list);
		return list1;
	}

	@Override
	public List<List<CloudGoodsSupplierEntity>> getListOfCloudGoodsSupplier(List<CloudGoodsEntity> list,List<SupplierEntity> list0) {
		List<List<CloudGoodsSupplierEntity>> list1 = new ArrayList<List<CloudGoodsSupplierEntity>>();
		for (CloudGoodsEntity goods : list) {
			List<CloudGoodsSupplierEntity> list2 = new ArrayList<CloudGoodsSupplierEntity>();
			String hql = "from CloudGoodsSupplierEntity cgs where cgs.goods.id="+goods.getId();
			for (SupplierEntity supp : list0) {
				List<CloudGoodsSupplierEntity> list3 = cloudGoodsSupplierDao.getListObject(hql+"and cgs.supp.id="+supp.getId());
				if(list3.isEmpty()) {
					list2.add(null);
				}else {
					list2.add(list3.get(0));
				}
				
				
			}
			list1.add(list2);
		}
		return list1;
	}

	@Override
	public void determineScheme(int id, String[] goodsId, String[] supplierId, String[] buyNum, UserEntity user) {
		int reBuyNum = buyNum.length;
		float totalPrice = 0;
		List<String> price = new ArrayList<String>();
		DateToString d = new DateToString();
		String date = d.getStringTime(new Date());
		UserBuyPlanEntity ubp = userBuyPlanDao.getByIdObject(id);
		Set<SupplierEntity> suppSet = new HashSet<SupplierEntity>();
		List<SupplierEntity> suppList1 = new ArrayList<SupplierEntity>();
		List<SupplierEntity> suppList2 = new ArrayList<SupplierEntity>();//购买的所有供应商，含重复
		Map<String, String> map = new HashMap<>();
		for (int i=0;i<supplierId.length;i++) {
			CloudGoodsSupplierEntity cgs = cloudGoodsSupplierDao.getByIdObject(Integer.parseInt(supplierId[i]));
			price.add(cgs.getPrice());
			suppList2.add(cgs.getSupp());
			if(!suppSet.contains(cgs.getSupp())) {
				suppSet.add(cgs.getSupp());
				suppList1.add(cgs.getSupp());
			}

		}
		for (int i=0;i<buyNum.length;i++) {
			totalPrice += Float.parseFloat(price.get(i))*Integer.parseInt(buyNum[i]);
		}
		//保存方案
		UserBuySchemeEntity ubs = new UserBuySchemeEntity();
		ubs.setAddTime(date);
		ubs.setName(ubp.getName());
		ubs.setReBuyNum(reBuyNum);
		ubs.setState("0");
		ubs.setPlanBuyNum(ubp.getTotalGoods());
		ubs.setTotalPrice(totalPrice);
		ubs.setUser(user);
		ubs.setUbp(ubp);
		ubs.setSupplier(suppSet);
		userBuySchemeDao.sava(ubs);
		UserBuySchemeEntity ubs1 = userBuySchemeDao.findObject("from UserBuySchemeEntity ubs where ubs.addTime='"+date+"' and ubs.user.id="+user.getId());
		//保存子方案，让子方案在数据库中获得id
		for (int i=0;i<suppList1.size();i++) {
			ChildSchemeEntity childScheme = new ChildSchemeEntity();
			int buyNumOfSupp = 0;
			float totalPriceOfSupp = 0;
			for(int j=0;j<suppList2.size();j++) {
				if(suppList1.get(i)==suppList2.get(j)) {
					buyNumOfSupp ++;
					totalPriceOfSupp += Float.parseFloat(price.get(j))*Integer.parseInt(buyNum[j]);
				}
				if(j==suppList2.size()-1) {
					childScheme.setBuyNum(buyNumOfSupp);
					childScheme.setPrice(totalPriceOfSupp);
					childScheme.setSupp(suppList1.get(i));
					childScheme.setUbs(ubs1);
					childSchemeDao.sava(childScheme);
				}
			}
		}
		
		//保存商品
		List<ChildSchemeEntity> list = childSchemeDao.getListObject("from ChildSchemeEntity cs where cs.ubs.id="+ubs1.getId());
		for(int j=0;j<list.size();j++) {
			for(int i=0;i<goodsId.length;i++) {
				if(list.get(j).getSupp()==suppList2.get(i)) {
					BuySchemeEntity bs = new BuySchemeEntity();
					BuyPlanEntity bp = buyPlanDao.getByIdObject(Integer.parseInt(goodsId[i]));
					bs.setComName(bp.getComName());
					bs.setBarCode(bp.getBarCode());
					bs.setDrug(bp.getDrug());
					bs.setErpNo(bp.getErpNo());
					bs.setLicenseNo(bp.getLicenseNo());
					bs.setPlanBuyNum(bp.getBuyNum());
					bs.setProduceFact(bp.getProduceFact());
					bs.setSpec(bp.getSpec());
					bs.setUnit(bp.getUnit());
					bs.setPrice(Float.parseFloat(price.get(i)));
					bs.setReBuyNum(Integer.parseInt(buyNum[i]));
					bs.setSupp(suppList2.get(i));
					bs.setChildScheme(list.get(j));			
					buySchemeDao.sava(bs);
				}
			}
		}
		
		ubp.setState("2");
		userBuyPlanDao.updateObject(ubp);
	}

	@Override
	public PageBean getListOfChildScheme(int id, int pageNo, int pageSize) {
		int totalNum = (int) getTotalNumOfChildScheme(id);
		PageBean pb = new PageBean(pageNo, pageSize, totalNum);
		String hql = "from ChildSchemeEntity cs where cs.ubs.id="+id;
		List<ChildSchemeEntity> list = childSchemeDao.getListPageObject(hql, pb.getNum(), pageSize);
		pb.setList(list);
		return pb;
	}

	@Override
	public long getTotalNumOfChildScheme(int id) {
		String hql = "select count(*) from ChildSchemeEntity cs where cs.ubs.id="+id;
		return childSchemeDao.getTotalNum2(hql);
	}

	@Override
	public UserBuySchemeEntity getById(int id) {
		// TODO Auto-generated method stub
		return userBuySchemeDao.getByIdObject(id);
	}

	@Override
	public void delById(int id) {
		UserBuySchemeEntity ubs = userBuySchemeDao.getByIdObject(id);
		List<ChildSchemeEntity> list = childSchemeDao.getListObject("from ChildSchemeEntity cs where cs.ubs.id="+id);
		for (ChildSchemeEntity childSchemeEntity : list) {
			List<BuySchemeEntity> list1 = buySchemeDao.getListObject("from BuySchemeEntity bs where bs.childScheme.id="+childSchemeEntity.getId());
			for (BuySchemeEntity buySchemeEntity : list1) {
				buySchemeDao.delete(buySchemeEntity);
			}
			childSchemeDao.delete(childSchemeEntity);
		}
		userBuySchemeDao.delete(ubs);
	}

	@Override
	public void delByUBS(UserBuySchemeEntity ubs) {
		userBuySchemeDao.delete(ubs);
		
	}

	@Override
	public List<UserBuySchemeEntity> getListOfINDEX(UserEntity user) {
		String hql = "from UserBuySchemeEntity ubs where ubs.state='1'" +"and ubs.user.id="+user.getId()+" order by ubs.subTime desc";
		return userBuySchemeDao.getListPageObject(hql, 0, 7);
	}

	@Override
	public List<ChildSchemeEntity> getListOfChildScheme(UserEntity user) {
			UserBuySchemeEntity ubs = this.getNew(user);
			if(ubs!=null) {
				String hql = "from ChildSchemeEntity cs where cs.ubs.id="+ubs.getId();
				return childSchemeDao.getListObject(hql);
			}
		return null;
	}

	@Override
	public UserBuySchemeEntity getNew(UserEntity user) {
		String hql = "from UserBuySchemeEntity ubs where ubs.state='1'" +"and ubs.user.id="+user.getId()+" order by ubs.subTime desc";
		if(userBuySchemeDao.getListPageObject(hql, 0, 1).size()!=0) {
			return userBuySchemeDao.getListPageObject(hql, 0, 1).get(0);
		}
		return null;
	}

	@Override
	public void updata(UserBuySchemeEntity ubs) {
		userBuySchemeDao.updateObject(ubs);
		
	}



}
