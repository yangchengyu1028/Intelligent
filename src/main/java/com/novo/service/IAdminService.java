package com.novo.service;

import com.novo.entity.AdminEntity;

public interface IAdminService {
	/**
	 * 通过账号查询该管理员是否存在
	 * @param name
	 * @return
	 */
	public AdminEntity getAdmin(String name,String password);
}
