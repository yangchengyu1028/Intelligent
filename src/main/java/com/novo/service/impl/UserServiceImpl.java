package com.novo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novo.dao.UserDao;
import com.novo.entity.UserEntity;
import com.novo.service.IUserService;
import com.novo.util.PageBean;
@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserDao userDao;

	@Override
	public UserEntity findUser(String name,String password) {
	
		//String sql ="select * from user where user.u_name='"+ name +"'and user.u_password='"+password+"'";
		//return UserEntity.findObject(sql, obj);
		String hql ="from UserEntity u where u.name = ? and u.password=?";
		List<String> list=new ArrayList<String>() ;
			list.add(name);
			list.add(password);			
		
		return userDao.findObject(hql, list);
		
	}

	@Override
	public List<UserEntity> getAllList() {
		
		return userDao.getListObject();
	}
	
	@Override
	public PageBean getList(String realName, String state, int pageNo, int pageSize) {
		
		int totalNum = (int) getTotalNum(realName,state);
		PageBean pb = new PageBean(pageNo, pageSize, totalNum);
		List<String> list = new ArrayList<String>();
		String hql = "from UserEntity  where state='"+state+"'";
		if (realName != null && !"".equals(realName)) {
			hql += " and realName like ? ";
			list.add("%" + realName + "%");
		}
		
		List<UserEntity> list1 = userDao.getListPageObject(hql, list, pb.getNum(), pageSize);
		pb.setList(list1);
		
		return pb;
	}

	@Override
	public long getTotalNum(String realName, String state) {
		
		List<String> list = new ArrayList<String>();
		String hql = "select count(*) from UserEntity where state='"+state+"'";
		if (realName != null && !"".equals(realName)) {
			hql += " and realName like ? ";
			list.add("%" + realName + "%");
		}
		
		return userDao.getListAllNums(hql, list);
	}

	@Override
	public UserEntity getById(int id) {
		// TODO Auto-generated method stub
		return userDao.getByIdObject(id);
	}

	@Override
	public void updata(UserEntity user) {
		// TODO Auto-generated method stub
		userDao.updateObject(user);
	}

	@Override
	public void save(UserEntity user) {
		// TODO Auto-generated method stub
		userDao.sava(user);
	}

}
