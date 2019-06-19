package com.novo.service;

import com.novo.entity.ChildSchemeEntity;

public interface IChildSchemeService {
	/**
	 * 通过id查找
	 * @param id
	 * @return
	 */
	public ChildSchemeEntity getById(int id);
	/**
	 * 修改
	 * @param cs
	 */
	public void updata(ChildSchemeEntity cs);
	
	
}
