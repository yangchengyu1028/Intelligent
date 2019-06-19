package com.novo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.novo.entity.UserEntity;
import com.novo.entity.UserSupplierEntity;
import com.novo.service.ISupplierService;
import com.novo.util.PageBean;

@Controller
public class SupplierController {
	
	@Autowired
	private ISupplierService supplierService;
	
	@RequestMapping("supplierManage.novo")
	public String supplierManage(HttpSession session) {
		if(null==session.getAttribute("user")) {
			return "login";
		}
		
		return "supplierManage";
	}
	
	@RequestMapping("getSupplier.novo")
	@ResponseBody
	public PageBean getSupplier(String name,String marryState,int pageNo,int pageSize,HttpSession session) {
		
		UserEntity user = (UserEntity) session.getAttribute("user");
		return supplierService.getList(name, marryState, pageNo, pageSize,user);
	}
	
	@RequestMapping("cancel.novo")
	@ResponseBody
	public String cancel(int id,HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		UserSupplierEntity us = supplierService.getById(id,user);
		us.setBuyerState(0);
		supplierService.updateOfState(us);
		
		return "success";
	}
	
	@RequestMapping("matching.novo")
	@ResponseBody
	public String matching(int id,HttpSession session) {
		
		UserEntity user = (UserEntity) session.getAttribute("user");
		UserSupplierEntity us = supplierService.getById(id,user);
		us.setBuyerState(1);
		supplierService.updateOfState(us);
		
		return "success";
	}
	
	@RequestMapping("addSupplierOfCompare.novo")
	@ResponseBody
	public List<UserSupplierEntity> addSupplierOfCompare(String name,HttpSession session) {
		
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<UserSupplierEntity> list = supplierService.getListOfNoRe(name,user);
		return list;
	}
	
}
