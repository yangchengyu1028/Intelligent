package com.novo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novo.dao.UserBuyPlanDao;
import com.novo.entity.UserBuyPlanEntity;
import com.novo.entity.UserEntity;
import com.novo.service.IUserBuyPlanService;
import com.novo.util.PageBean;
@Service("userBuyPlanService")
public class UserBuyPlanServiceImpl implements IUserBuyPlanService{

	@Autowired
	private UserBuyPlanDao userBuyPlanDao;
	
	@Override
	public PageBean getList(String planTime, String manageTime, String state, int pageNo, int pageSize,UserEntity user) {
		int totalNum = (int) getTotalNum(planTime,manageTime,state,user);
		PageBean pb = new PageBean(pageNo, pageSize, totalNum);
		List<String> list = new ArrayList<String>();
		String hql = "from UserBuyPlanEntity ub where 1=1 ";
		if(planTime != null && !"".equals(planTime)) {
			hql += " and ub.planTime >= ? ";
			list.add(planTime);
		}
		if(manageTime != null && !"".equals(manageTime)) {
			hql += " and ub.manageTime >= ? ";
			list.add(manageTime);
		}
		if(state != null && !"".equals(state)) {
			hql += " and ub.state = ? ";
			list.add(state);
		}
		hql += "and ub.user.id="+user.getId();
		List<UserBuyPlanEntity> list1 = userBuyPlanDao.getListPageObject(hql, list, pb.getNum(), pageSize);

		pb.setList(list1);
		return pb;
	}

	@Override
	public long getTotalNum(String planTime, String manageTime, String state,UserEntity user) {
		List<String> list = new ArrayList<String>();
		String hql = "select count(*) from UserBuyPlanEntity ub where 1=1 ";
		if(planTime != null&&!"".equals(planTime)) {
			hql += " and ub.planTime >= ? ";
			list.add(planTime);
		}
		if(manageTime != null&&!"".equals(manageTime)) {
			hql += " and ub.manageTime >= ? ";
			list.add(manageTime);
		}
		if(state != null&&!"".equals(state)) {
			hql += " and ub.state = ? ";
			list.add(state);
		}
		hql += "and ub.user.id="+user.getId();
		return userBuyPlanDao.getListAllNums(hql, list);
	}

	@Override
	public void save(UserBuyPlanEntity ubp) {
		
		userBuyPlanDao.sava(ubp);
		
	}

	@Override
	public UserBuyPlanEntity query(String planTime,UserEntity user) {
		
		List<String> list = new ArrayList<String>();
		String hql = "from UserBuyPlanEntity ub where ub.planTime = ? and ub.user.id="+user.getId();
		list.add(planTime);
		return userBuyPlanDao.findObject(hql, list);
	}

	@Override
	public void update(UserBuyPlanEntity ubp) {
		
		userBuyPlanDao.updateObject(ubp);
		
	}

	@Override
	public UserBuyPlanEntity getById(int id) {
		// TODO Auto-generated method stub
		return userBuyPlanDao.getByIdObject(id);
	}

	@Override
	public void delete(UserBuyPlanEntity ubp) {

		userBuyPlanDao.delete(ubp);
		
	}

}
