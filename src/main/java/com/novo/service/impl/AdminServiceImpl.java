package com.novo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novo.dao.AdminDao;
import com.novo.entity.AdminEntity;
import com.novo.service.IAdminService;

@Service("adminService")
public class AdminServiceImpl implements IAdminService{
	@Autowired
	private AdminDao adminDao;
	@Override
	public AdminEntity getAdmin(String name,String password) {
		// TODO Auto-generated method stub
		String hql = "from AdminEntity where name='"+name+"' and password='"+password+"'";
		return adminDao.findObject(hql);
	}

}
