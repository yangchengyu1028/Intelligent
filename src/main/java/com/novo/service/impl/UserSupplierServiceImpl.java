package com.novo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novo.dao.UserSupplierDao;
import com.novo.entity.SupplierEntity;
import com.novo.entity.UserEntity;
import com.novo.entity.UserSupplierEntity;
import com.novo.service.IUserSupplierService;
import com.novo.util.PageBean;
@Service("userSupplierService")
public class UserSupplierServiceImpl implements IUserSupplierService {
	@Autowired
	private UserSupplierDao userSupplierDao;
	
	@Override
	public void save(UserSupplierEntity us) {
		userSupplierDao.sava(us);

	}

	@Override
	public Boolean exist(UserEntity user, SupplierEntity supp) {
		String hql = "from UserSupplierEntity us where us.user.id="+user.getId()+" and us.supplier.id="+supp.getId();
		UserSupplierEntity us = userSupplierDao.findObject(hql);
		if(us==null) {
			return false;
		}
		
		return true;
	}

	@Override
	public void updataOfNum(UserSupplierEntity us) {
		userSupplierDao.updateObject(us);
		
	}

	@Override
	public UserSupplierEntity getUS(int userId, int suppId) {
		String hql = "from UserSupplierEntity where user.id="+userId+" and supplier.id="+suppId;
		return userSupplierDao.findObject(hql);
	}

	@Override
	public PageBean getList(String name, String sellerState, int pageNo, int pageSize, SupplierEntity entity) {
		int totalNum = (int) getTotalNum(name,sellerState,entity);
		PageBean pb = new PageBean(pageNo, pageSize, totalNum);
		List<String> list = new ArrayList<String>();
		String hql = "from UserSupplierEntity us where us.marryState=1 and us.supplier.id= "+entity.getId();
		if (name != null && !"".equals(name)) {
			hql += " and us.supplier.name like ? ";
			list.add("%" + name + "%");
		}
		hql += "and us.sellerState ="+sellerState;
		List<UserSupplierEntity> list1 = userSupplierDao.getListPageObject(hql, list, pb.getNum(), pageSize);
		pb.setList(list1);
		
		return pb;
	}

	@Override
	public long getTotalNum(String name, String sellerState, SupplierEntity entity) {
		List<String> list = new ArrayList<String>();
		String hql = "select count(*) from UserSupplierEntity us where us.marryState=1 and us.supplier.id="+entity.getId();
		if (name != null && !"".equals(name)) {
			hql += " and us.supplier.name like ? ";
			list.add("%" + name + "%");
		}
		hql += "and us.sellerState = "+sellerState;
		
		return userSupplierDao.getListAllNums(hql, list);
	}

	@Override
	public UserSupplierEntity getById(int id) {
		// TODO Auto-generated method stub
		return userSupplierDao.getByIdObject(id);
	}

	@Override
	public void update(UserSupplierEntity entity) {
		// TODO Auto-generated method stub
		userSupplierDao.updateObject(entity);
	}

	@Override
	public List<UserSupplierEntity> getAll() {
		// TODO Auto-generated method stub
		return userSupplierDao.getListObject();
	}

	@Override
	public PageBean getBuyerList(String name, String marryState, int pageNo, int pageSize, int supplierId) {
		int totalNum = (int) getBuyerTotalNum(name,marryState,supplierId);
		PageBean pb = new PageBean(pageNo, pageSize, totalNum);
		List<String> list = new ArrayList<String>();
		String hql = "from UserSupplierEntity us where us.supplier.id= "+supplierId;
		if (name != null && !"".equals(name)) {
			hql += " and us.user.realName like ? ";
			list.add("%" + name + "%");
		}
		hql += "and us.marryState ="+marryState;
		List<UserSupplierEntity> list1 = userSupplierDao.getListPageObject(hql, list, pb.getNum(), pageSize);
		pb.setList(list1);
		
		return pb;
	}

	@Override
	public long getBuyerTotalNum(String name, String marryState, int supplierId) {
		List<String> list = new ArrayList<String>();
		String hql = "select count(*) from UserSupplierEntity us where us.supplier.id="+supplierId;
		if (name != null && !"".equals(name)) {
			hql += " and us.user.realName like ? ";
			list.add("%" + name + "%");
		}
		hql += "and us.marryState = "+marryState;
		
		return userSupplierDao.getListAllNums(hql, list);
	}
	@Override
	public PageBean getSellerList(String name, String marryState, int pageNo, int pageSize, int userId) {
		int totalNum = (int) getBuyerTotalNum(name,marryState,userId);
		PageBean pb = new PageBean(pageNo, pageSize, totalNum);
		List<String> list = new ArrayList<String>();
		String hql = "from UserSupplierEntity us where us.user.id= "+userId;
		if (name != null && !"".equals(name)) {
			hql += " and us.supplier.name like ? ";
			list.add("%" + name + "%");
		}
		hql += "and us.marryState ="+marryState;
		List<UserSupplierEntity> list1 = userSupplierDao.getListPageObject(hql, list, pb.getNum(), pageSize);
		pb.setList(list1);
		
		return pb;
	}

	@Override
	public long getSellerTotalNum(String name, String marryState, int userId) {
		List<String> list = new ArrayList<String>();
		String hql = "select count(*) from UserSupplierEntity us where us.user.id="+userId;
		if (name != null && !"".equals(name)) {
			hql += " and us.supplier.name like ? ";
			list.add("%" + name + "%");
		}
		hql += "and us.marryState = "+marryState;
		
		return userSupplierDao.getListAllNums(hql, list);
	}

}
