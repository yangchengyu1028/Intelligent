package com.novo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.novo.entity.ChildSchemeEntity;
import com.novo.entity.UserBuySchemeEntity;
import com.novo.entity.UserEntity;
import com.novo.service.ISupplierService;
import com.novo.service.IUserBuySchemeService;
import com.novo.service.IUserProductService;

@Controller
public class IndexController {
	@Autowired
	private IUserProductService userProductService;
	@Autowired
	private ISupplierService supplierService;
	@Autowired
	private IUserBuySchemeService userBuySchemeService;
	
	@RequestMapping("getDataOfIndex.novo")
	@ResponseBody
	public ModelAndView getDataOfIndex(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		UserEntity user = (UserEntity) session.getAttribute("user");
		ModelAndView mv = null;
		if(null==user) {
			mv = new ModelAndView("login");
		}else {
			mv = new ModelAndView("index");
		}
		
		
		int reGoodsNum = userProductService.getNumOfRele(user);
		int noReGoodsNum = userProductService.getNumOfNoRele(user);
		int reSupplierNum = supplierService.getNumOfsupp(user);
		List<ChildSchemeEntity> csList = userBuySchemeService.getListOfChildScheme(user);
		if(csList!=null) {
			for (int i=0;i<csList.size();i++) {
				if(csList.get(i).getBuyNum()==0) {
					csList.remove(i);
				}
			}
		}
		request.setAttribute("reGoodsNum", reGoodsNum);
		request.setAttribute("noReGoodsNum", noReGoodsNum);
		request.setAttribute("reSupplierNum", reSupplierNum);
		request.setAttribute("csList", csList);
		request.setAttribute("newScheme", userBuySchemeService.getNew(user));
		return mv;
	}
	
	@RequestMapping("getDiscountingData.novo")
	@ResponseBody
	public List<UserBuySchemeEntity> getDiscountingData(HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<UserBuySchemeEntity> ubsList = userBuySchemeService.getListOfINDEX(user);
		return ubsList;
	}

}
