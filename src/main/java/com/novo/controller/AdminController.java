package com.novo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.novo.entity.SupplierEntity;
import com.novo.entity.UserEntity;
import com.novo.entity.UserSupplierEntity;
import com.novo.service.ICloudGoodsSupplierService;
import com.novo.service.ISupplierService;
import com.novo.service.IUserService;
import com.novo.service.IUserSupplierService;
import com.novo.util.PageBean;

@Controller
public class AdminController {
	
	@Autowired
	private ISupplierService supplierService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IUserSupplierService userSupplierService;
	@Autowired
	private ICloudGoodsSupplierService cloudGoodsSupplierService;
	
	@RequestMapping("adminManage.novo")
	public String adminManage(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if(null==session.getAttribute("admin")) {
			
			return "login";
		}
		
		return "allGoodsManage";
	}
	@RequestMapping("adminSellerManage.novo")
	public String adminSellerManage(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if(null==session.getAttribute("admin")) {
			
			return "login";
		}
		
		return "adminSellerManage";
	}
	@RequestMapping("adminBuyerManage.novo")
	public String adminBuyerManage(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if(null==session.getAttribute("admin")) {
			
			return "login";
		}
		
		return "adminBuyerManage";
	}
	@RequestMapping("adminSellerDetails.novo")
	public String adminSellerDetails(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if(null==session.getAttribute("admin")) {
			
			return "login";
		}
		
		return "adminSellerDetails";
	}
	@RequestMapping("adminBuyerDetails.novo")
	public String adminBuyerDetails(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if(null==session.getAttribute("admin")) {
			
			return "login";
		}
		
		return "adminBuyerDetails";
	}
	@RequestMapping("getSupplierOfAdmin.novo")
	@ResponseBody
	public PageBean getSupplierOfAdmin(String name,String state,int pageNo,int pageSize) {
		
		return supplierService.getList(name, state, pageNo, pageSize);
	}
	@RequestMapping("cancelSellerOfAdmin.novo")
	@ResponseBody
	public String cancelSellerOfAdmin(int id) {
		SupplierEntity s = supplierService.getById(id);
		s.setState("0");
		supplierService.updata(s);
		
		return "success";
	}
	@RequestMapping("matchingSellerOfAdmin.novo")
	@ResponseBody
	public String matchingSellerOfAdmin(int id) {
		
		SupplierEntity s = supplierService.getById(id);
		s.setState("1");
		supplierService.updata(s);
		
		return "success";
	}
	@RequestMapping("getBuyerBySellerOfAdmin.novo")
	@ResponseBody
	public PageBean getBuyerBySellerOfAdmin(String name,String marryState,int pageNo,int pageSize,int supplierId) {
		
		return userSupplierService.getBuyerList(name, marryState, pageNo, pageSize,supplierId);
	}
	@RequestMapping("addSellerOfAdmin.novo")
	@ResponseBody
	public String addSellerOfAdmin(String name,String mobile) {
		//保存新添加商家
		SupplierEntity supplierEntity = new SupplierEntity();
		supplierEntity.setName(name);
		supplierEntity.setMobile(mobile);
		supplierEntity.setState("1");
		supplierService.save(supplierEntity);
		//获取该商家，得到完整实体
		SupplierEntity supplierEntity1 = supplierService.getByNameAndMobile(name, mobile);
		//获取所有下游买家
		List<UserEntity> list = userService.getAllList();
		//循环将新添加的商家和下游所有买家（含注销买家，避免再次入驻后未关联）关联
		UserSupplierEntity userSupplierEntity = null;
		for(int i=0,j=list.size();i<j;i++) {
			userSupplierEntity = new UserSupplierEntity();
			userSupplierEntity.setMarryState("0");
			userSupplierEntity.setBuyerState(0);
			userSupplierEntity.setSellerState(1);
			userSupplierEntity.setSupplier(supplierEntity1);
			userSupplierEntity.setCount(cloudGoodsSupplierService.getAllNum(supplierEntity1));
			userSupplierEntity.setUser(list.get(i));
			userSupplierService.save(userSupplierEntity);
		}
		
		return "1";
	}
	@RequestMapping("getBuyerOfAdmin.novo")
	@ResponseBody
	public PageBean getBuyerOfAdmin(String realName,String state,int pageNo,int pageSize) {
		
		return userService.getList(realName, state, pageNo, pageSize);
	}
	@RequestMapping("cancelBuyerOfAdmin.novo")
	@ResponseBody
	public String cancelBuyerOfAdmin(int id) {
		UserEntity s = userService.getById(id);
		s.setState("0");
		userService.updata(s);
		
		return "success";
	}
	@RequestMapping("matchingBuyerOfAdmin.novo")
	@ResponseBody
	public String matchingBuyerOfAdmin(int id) {
		
		UserEntity s = userService.getById(id);
		s.setState("1");
		userService.updata(s);
		
		return "success";
	}
	@RequestMapping("addBuyerOfAdmin.novo")
	@ResponseBody
	public String addBuyerOfAdmin(String realName,String name,String password,String phone) {
		//保存新添加买家
		UserEntity user = new UserEntity();
		user.setName(name);
		user.setPhone(phone);
		user.setPassword(password);
		user.setRealName(realName);
		user.setState("1");
		userService.save(user);
		//获取该商家，得到完整实体
		UserEntity user1 = userService.findUser(name, password);
		//获取所有下游买家
		List<SupplierEntity> list = supplierService.getAll();
		//循环将新添加的商家和下游所有买家（含注销买家，避免再次入驻后未关联）关联
		UserSupplierEntity userSupplierEntity = null;
		for(int i=0,j=list.size();i<j;i++) {
			userSupplierEntity = new UserSupplierEntity();
			userSupplierEntity.setMarryState("0");
			userSupplierEntity.setBuyerState(0);
			userSupplierEntity.setSellerState(1);
			userSupplierEntity.setSupplier(list.get(i));
			userSupplierEntity.setCount(cloudGoodsSupplierService.getAllNum(list.get(i)));
			userSupplierEntity.setUser(user1);
			userSupplierService.save(userSupplierEntity);
		}
		
		return "1";
	}
	@RequestMapping("getSellerByBuyerOfAdmin.novo")
	@ResponseBody
	public PageBean getSellerByBuyerOfAdmin(String name,String marryState,int pageNo,int pageSize,int buyerId) {
		
		return userSupplierService.getSellerList(name, marryState, pageNo, pageSize,buyerId);
	}
	@RequestMapping("cancelBuyerAndSellerRelevanceOfAdmin.novo")
	@ResponseBody
	public String cancelBuyerAndSellerRelevanceOfAdmin(int id) {
		UserSupplierEntity s = userSupplierService.getById(id);
		s.setMarryState("0");
		userSupplierService.update(s);
		
		return "1";
	}
	@RequestMapping("matchingBuyerAndSellerRelevanceOfAdmin.novo")
	@ResponseBody
	public String matchingBuyerAndSellerRelevanceOfAdmin(int id) {
		
		UserSupplierEntity s = userSupplierService.getById(id);
		s.setMarryState("1");
		userSupplierService.update(s);
		
		return "1";
	}
	
}
