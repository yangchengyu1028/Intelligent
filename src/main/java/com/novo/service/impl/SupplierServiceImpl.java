package com.novo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novo.dao.SupplierDao;
import com.novo.dao.UserSupplierDao;
import com.novo.entity.SupplierEntity;
import com.novo.entity.UserEntity;
import com.novo.entity.UserSupplierEntity;
import com.novo.service.ISupplierService;
import com.novo.util.PageBean;

@Service("supplierService")
public class SupplierServiceImpl implements ISupplierService{
	@Autowired
	private SupplierDao supplierDao;
	@Autowired
	private UserSupplierDao userSupplierDao;

	@Override
	public PageBean getList(String name, String buyerState, int pageNo, int pageSize,UserEntity user) {
		
		int totalNum = (int) getTotalNum(name,buyerState,user);
		PageBean pb = new PageBean(pageNo, pageSize, totalNum);
		List<String> list = new ArrayList<String>();
		String hql = "from UserSupplierEntity us where us.sellerState=1 and us.marryState='1' and us.user.id= "+user.getId();
		if (name != null && !"".equals(name)) {
			hql += " and us.supplier.name like ? ";
			list.add("%" + name + "%");
		}
		hql += "and us.buyerState ="+buyerState;
		List<UserSupplierEntity> list1 = userSupplierDao.getListPageObject(hql, list, pb.getNum(), pageSize);
		pb.setList(list1);
		
		return pb;
	}

	@Override
	public long getTotalNum(String name, String buyerState,UserEntity user) {
		
		List<String> list = new ArrayList<String>();
		String hql = "select count(*) from UserSupplierEntity us where us.sellerState=1 and us.marryState='1' and us.user.id="+user.getId();
		if (name != null && !"".equals(name)) {
			hql += " and us.supplier.name like ? ";
			list.add("%" + name + "%");
		}
		hql += "and us.buyerState ="+buyerState;
		
		return userSupplierDao.getListAllNums(hql, list);
	}

	@Override
	public UserSupplierEntity getById(int id,UserEntity user) {
		String hql = "from UserSupplierEntity us where us.id= "+id;
		hql += "and us.user.id= "+user.getId();
		
		return userSupplierDao.findObject(hql);
	}

	@Override
	public void updateOfState(UserSupplierEntity us) {
		
		userSupplierDao.updateObject(us);
		
	}
	
	@Override
	public List<UserSupplierEntity> getListOfRe(UserEntity user) {
		String hql = "from UserSupplierEntity us where us.sellerState=1 and us.buyerState=1 and us.marryState='1' and us.user.id= "+user.getId();
		return userSupplierDao.getListObject(hql);
	}

	@Override
	public List<UserSupplierEntity> getListOfNoRe(String name,UserEntity user) {
		List<String> list = new ArrayList<String>();
		String hql = "from UserSupplierEntity us where us.sellerState=1 and us.marryState='1' and us.buyerState=0 and us.user.id= "+user.getId();
		if(name !=null&&!"".equals(name)) {
			hql += " and us.supplier.name like ? ";
			list.add("%"+name+"%");
		}
		
		return userSupplierDao.getListObject(hql, list);
	}

	@Override
	public int getNumOfsupp(UserEntity user) {
		String hql = "select count(*) from UserSupplierEntity us where us.sellerState=1 and us.marryState='1' and us.buyerState=1 and us.user.id="+user.getId();
		
		return userSupplierDao.getTotalNum2(hql);
	}

	@Override
	public void save(SupplierEntity supp) {
		
		supplierDao.sava(supp);
	}

	@Override
	public Boolean exist(int id) {
		String hql = "from SupplierEntity where id='"+id+"'";
		if(supplierDao.findObject(hql)==null) {
			return false;
		}
		return true;
	}

	@Override
	public List<SupplierEntity> getAll() {
		String hql = "from SupplierEntity";
		return supplierDao.getListObject(hql);
	}


	@Override
	public SupplierEntity getById(int id) {
		// TODO Auto-generated method stub
		return supplierDao.getByIdObject(id);
	}

	@Override
	public List<UserSupplierEntity> list(int id) {
		String hql = "from UserSupplierEntity us where us.user.id="+id;
		return userSupplierDao.getListObject(hql);
	}

	@Override
	public void updata(SupplierEntity supp) {
		// TODO Auto-generated method stub
		supplierDao.updateObject(supp);
	}

	@Override
	public SupplierEntity getByNameAndMobile(String name, String mobile) {
		String hql = "from SupplierEntity  where name='"+name+"' and mobile='"+mobile+"'";
		return supplierDao.findObject(hql);
	}

	@Override
	public PageBean getList(String name, String state, int pageNo, int pageSize) {
		
		int totalNum = (int) getTotalNum(name,state);
		PageBean pb = new PageBean(pageNo, pageSize, totalNum);
		List<String> list = new ArrayList<String>();
		String hql = "from SupplierEntity  where state='"+state+"'";
		if (name != null && !"".equals(name)) {
			hql += " and name like ? ";
			list.add("%" + name + "%");
		}
		
		List<SupplierEntity> list1 = supplierDao.getListPageObject(hql, list, pb.getNum(), pageSize);
		pb.setList(list1);
		
		return pb;
	}

	@Override
	public long getTotalNum(String name, String state) {
		
		List<String> list = new ArrayList<String>();
		String hql = "select count(*) from SupplierEntity where state='"+state+"'";
		if (name != null && !"".equals(name)) {
			hql += " and name like ? ";
			list.add("%" + name + "%");
		}
		
		return supplierDao.getListAllNums(hql, list);
	}

}
