package com.novo.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.novo.entity.AdminEntity;
import com.novo.entity.SupplierEntity;
import com.novo.entity.UserEntity;
import com.novo.entity.UserSupplierEntity;
import com.novo.service.IAdminService;
import com.novo.service.ISupplierService;
import com.novo.service.IUserService;
import com.novo.service.IUserSupplierService;
import com.novo.util.PageBean;

@Controller("controller")
public class UserController {

	@Autowired
	IUserService userservice;
	@Autowired
	private ISupplierService supplierService;
	@Autowired
	private IUserSupplierService userSupplierService;
	@Autowired
	private IAdminService adminService;

	@RequestMapping("login.novo")
	public ModelAndView toLogin() {
		ModelAndView mv = new ModelAndView("login");
		return mv;

	}

	// 用户登录 
	@RequestMapping("userLogin.novo")
	@ResponseBody
	public String login(String username, String password,HttpServletRequest request) {
		username = username.trim();
		password = password.trim();
		HttpSession session = request.getSession(true);
		if(isChinese(username)) {
			SupplierEntity entity = supplierService.getByNameAndMobile(username, password);
			if(null!=entity) {
				session.setAttribute("supplier", entity);
				
				return "2";
			}else {
				return "密码错误！";
			}
		}else if(isEnglish(username)) {
			AdminEntity adminEntity = adminService.getAdmin(username,password);
			
			if(null != adminEntity) {
				session.setAttribute("admin", adminEntity);
				return "3";
			}else {
				return "密码错误！";
			}
		}else {
			UserEntity user = userservice.findUser(username, password);
			if(user!=null) {
				if(user.getState().equals("1")) {
					session.setAttribute("user", user);
						
					return "1";
				}else {
					return "该用户已失效！";
				}	
			}else {
				return "密码错误！";
			}
		}
		
		
	}
	
	//买家退出登录
	@RequestMapping("outlogin.novo")
	public String outlogin(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.removeAttribute("user");
		return "redirect:/login.novo";
		
	}
	//卖家退出登录
	@RequestMapping("outloginOfSeller.novo")
	public String outloginOfSeller(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.removeAttribute("supplier");
		return "redirect:/login.novo";
			
	}
	//卖家退出登录
		@RequestMapping("outloginOfAdmin.novo")
		public String outloginOfAdmin(HttpServletRequest request) {
			HttpSession session = request.getSession(false);
			session.removeAttribute("admin");
			return "redirect:/login.novo";
				
		}
	/**
	 * 判断是否为中文
	 * @param strName
	 * @return
	 */
	public boolean isChinese(String strName) {
	    char[] ch = strName.toCharArray();
	    for (int i = 0; i < ch.length; i++) {
	        char c = ch[i];
	        if (isChinese(c)) {
	            return true;
	        }
	    }
	    return false;
	}
	/**
	 * 判断是否为英文
	 * @param charaString
	 * @return
	 */
	public static boolean isEnglish(String charaString){
		return charaString.matches("^[a-zA-Z]*");
	}

	
	private boolean isChinese(char c) {
	    Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
	    if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
	            || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
	            || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
	            || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
	            || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
	            || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
	        return true;
	    }
	    return false;
	}
	
	@RequestMapping("getBuyerOfSeller.novo")
	@ResponseBody
	public PageBean getSupplier(String name,String sellerState,int pageNo,int pageSize,HttpSession session) {
		
		SupplierEntity user = (SupplierEntity) session.getAttribute("supplier");
		return userSupplierService.getList(name, sellerState, pageNo, pageSize,user);
	}
	
	@RequestMapping("cancelKeJian.novo")
	@ResponseBody
	public String cancel(int id,HttpSession session) {
		UserSupplierEntity us = userSupplierService.getById(id);
		us.setSellerState(0);
		userSupplierService.update(us);
		
		return "success";
	}
	
	@RequestMapping("matchingKeJian.novo")
	@ResponseBody
	public String matching(int id,HttpSession session) {
		
		UserSupplierEntity us = userSupplierService.getById(id);
		us.setSellerState(1);
		userSupplierService.update(us);
		
		return "success";
	}

}
