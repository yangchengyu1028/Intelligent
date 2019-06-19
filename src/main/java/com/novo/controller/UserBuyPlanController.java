package com.novo.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.novo.entity.UserBuyPlanEntity;
import com.novo.entity.UserEntity;
import com.novo.util.ExportExcel;
import com.novo.service.IBuyPlanService;
import com.novo.service.IUserBuyPlanService;
import com.novo.util.DateToString;
import com.novo.util.PageBean;

@Controller
public class UserBuyPlanController {
	
	@Autowired
	private IUserBuyPlanService userBuyPlanService;
	
	@Autowired
	private IBuyPlanService buyPlanService;
	private ExportExcel exportExcel = new ExportExcel();
	
	@RequestMapping("buyerPlan.novo")
	public String localGoods(HttpSession session) {
		if(null==session.getAttribute("user")) {
			return "login";
		}
		return "buyerPlan";
	}
	
	@RequestMapping("getUserBuyPlan.novo")
	@ResponseBody
	public PageBean getUserBuyPlan(String planTime, String manageTime, String state, int pageNo, int pageSize,HttpSession session) {
		
		UserEntity user = (UserEntity) session.getAttribute("user");
		return userBuyPlanService.getList(planTime, manageTime, state, pageNo, pageSize,user);
	
	}
	
	@RequestMapping("planDetails.novo")
	@ResponseBody
	public PageBean planDetails(String comName,String state,int id,int pageNo,int pageSize) {
		
		return buyPlanService.getList(comName, state, id, pageNo, pageSize);
	}
	
	@RequestMapping("delUserBuyPlan.novo")
	@ResponseBody
	public String delUserBuyPlan(int id) {
		
		UserBuyPlanEntity userBuyPlanEntity = userBuyPlanService.getById(id);
		userBuyPlanEntity.setState("9");
		userBuyPlanService.update(userBuyPlanEntity);
		
		return "success";
	}
	
	@RequestMapping("subUserBuyPlan.novo")
	@ResponseBody
	public String subUserBuyPlan(int id) {
		Date a = new Date();
		DateToString d = new DateToString();
		String manageTime = d.getStringTime(a);
		UserBuyPlanEntity ubp = userBuyPlanService.getById(id);
		ubp.setManageTime(manageTime);
		ubp.setState("1");
		userBuyPlanService.update(ubp);
		return "success";
	}
	
	@RequestMapping("exportBuyPlanExcel.novo")
	@ResponseBody
	public String exportNoSellGoodsExcel(HttpServletResponse response) {
		response.setContentType("application/binary;charset=UTF-8");
		try{
            ServletOutputStream out=response.getOutputStream();
            try {
                //设置文件头：最后一个参数是设置下载文件名(这里我们叫：张三.pdf)
                response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode("采购计划模板（所有单元格不能为空）.xls", "UTF-8"));
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
         
            String[] titles = { "通用名", "规格", "生产厂家", "批准文号", "条形码", "剂量", "单位", "erp编码", "预估价格","采购数量"}; 
            exportExcel.export(titles, out);      
            return "success";
        } catch(Exception e){
            e.printStackTrace();
            return "导出信息失败";
        }
    }
}
