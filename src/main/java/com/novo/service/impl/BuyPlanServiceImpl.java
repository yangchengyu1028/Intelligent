package com.novo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novo.dao.BuyPlanDao;
import com.novo.entity.BuyPlanEntity;
import com.novo.service.IBuyPlanService;
import com.novo.util.PageBean;
@Service
public class BuyPlanServiceImpl implements IBuyPlanService {
	
	@Autowired
	private BuyPlanDao buyPlanDao;
	
	public void save(BuyPlanEntity bp) {
		
		buyPlanDao.sava(bp);

	}

	@Override
	public PageBean getList(String comName, String state, int id, int pageNo, int pageSize) {
		int totalNum = (int) getTotalNum(comName,state,id);
		PageBean pb = new PageBean(pageNo, pageSize, totalNum);
		List<String> list = new ArrayList<String>();
		String hql = "from BuyPlanEntity bp where bp.state=? and bp.userBuyPlan.id="+id;
		list.add(state);
		if(comName != null && !"".equals(comName)) {
			hql += " and bp.comName like ?";
			list.add("%"+comName+"%");
		}
		List<BuyPlanEntity> list1 = buyPlanDao.getListPageObject(hql, list, pb.getNum(), pageSize);
		pb.setList(list1);
		return pb;
	}

	@Override
	public long getTotalNum(String comName, String state, int id) {
		List<String> list = new ArrayList<String>();
		String hql = "select count(*) from BuyPlanEntity bp where bp.state=? and bp.userBuyPlan.id="+id;
		list.add(state);
		if(comName != null && !"".equals(comName)) {
			hql += " and bp.comName like ?";
			list.add("%"+comName+"%");
		}
		return buyPlanDao.getListAllNums(hql, list);
	}

	@Override
	public List<BuyPlanEntity> getListById(int id) {
		String hql = "from BuyPlanEntity bp where bp.userBuyPlan.id="+id;
		return buyPlanDao.getListObject(hql);
	}

	@Override
	public void delete(BuyPlanEntity bp) {

		buyPlanDao.delete(bp);
		
	}

	@Override
	public List<BuyPlanEntity> getListOfRe(int id) {
		String hql = "from BuyPlanEntity bp where bp.state='1' and bp.userBuyPlan.id="+id;
		return buyPlanDao.getListObject(hql);
	}

	@Override
	public List<BuyPlanEntity> getListOfNoRe(int id) {
		String hql = "from BuyPlanEntity bp where bp.state='0' and bp.userBuyPlan.id="+id;
		return buyPlanDao.getListObject(hql);
	}

}
