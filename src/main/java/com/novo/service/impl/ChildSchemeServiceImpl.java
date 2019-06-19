package com.novo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novo.dao.ChildSchemeDao;
import com.novo.entity.ChildSchemeEntity;
import com.novo.service.IChildSchemeService;
@Service
public class ChildSchemeServiceImpl implements IChildSchemeService {
	@Autowired
	private ChildSchemeDao childSchemeDao;
	
	@Override
	public ChildSchemeEntity getById(int id) {
		// TODO Auto-generated method stub
		return childSchemeDao.getByIdObject(id);
	}

	@Override
	public void updata(ChildSchemeEntity cs) {
		childSchemeDao.updateObject(cs);

	}

}
