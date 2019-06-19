package com.novo.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.novo.dto.NoBuyDto;
import com.novo.dto.UserDataDto;
import com.novo.entity.BuyPlanEntity;
import com.novo.entity.BuySchemeEntity;
import com.novo.entity.CloudGoodsEntity;
import com.novo.entity.CloudGoodsSupplierEntity;
import com.novo.entity.SupplierEntity;
import com.novo.entity.UserBuyPlanEntity;
import com.novo.entity.UserBuySchemeEntity;
import com.novo.entity.UserEntity;
import com.novo.entity.UserSupplierEntity;
import com.novo.util.DateToString;
import com.novo.util.ExportExcel;
import com.novo.service.IBuyPlanService;
import com.novo.service.IBuySchemeService;
import com.novo.service.ICloudGoodsService;
import com.novo.service.ISupplierService;
import com.novo.service.IUserBuySchemeService;
import com.novo.util.PageBean;


@Controller
public class UserBuySchemeController {
	
	@Autowired
	private IUserBuySchemeService userBuySchemeService;
	@Autowired
	private IBuyPlanService buyPlanService;
	@Autowired
	private ISupplierService supplierService;
	@Autowired
	private ICloudGoodsService cloudGoodsService;
	@Autowired
	private IBuySchemeService buySchemeService;
	private ExportExcel exportExcel = new ExportExcel();
	private DateToString d = new DateToString();
	
	@RequestMapping("projectManage.novo")
	public String projectManage(HttpSession session) {
		if(null==session.getAttribute("user")) {
			return "login";
		}
		return "projectManage";
	}
	
	@RequestMapping("getUserBuyScheme.novo")
	@ResponseBody
	public PageBean getUserBuyScheme(String subTime,String addTime,String state,int pageNo,int pageSize,HttpSession session) {
		
		UserEntity user = (UserEntity) session.getAttribute("user");
		return userBuySchemeService.getList(subTime, addTime, state, pageNo, pageSize,user);
		
	}
	
	@RequestMapping("addScheme.novo")
	@ResponseBody
	public List<UserBuyPlanEntity> addScheme(String planTime,String manageTime,HttpSession session){
		
		UserEntity user = (UserEntity) session.getAttribute("user");
		
		return userBuySchemeService.getUserBuyPlan(planTime,manageTime,user);
	}
	
	@RequestMapping("getDataOfId.novo")
	@ResponseBody
	public UserDataDto getDataOfId(int id,HttpServletRequest request) {
		UserEntity user = (UserEntity) request.getSession().getAttribute("user");
		List<UserSupplierEntity> userSuppList = supplierService.getListOfRe(user);
		List<SupplierEntity> suppList = new ArrayList<SupplierEntity>();
		for (UserSupplierEntity userSupplierEntity : userSuppList) {
			suppList.add(userSupplierEntity.getSupplier());
		}
		List<BuyPlanEntity> buyPlanList = buyPlanService.getListOfRe(id);
		List<CloudGoodsEntity> cloudGoodsList = cloudGoodsService.getList(buyPlanList);
		List<List<CloudGoodsSupplierEntity>> cloudGoodsSupplierList = userBuySchemeService.getListOfCloudGoodsSupplier(cloudGoodsList, suppList);
		UserDataDto userDate = new UserDataDto(cloudGoodsSupplierList, buyPlanList, suppList);
		return userDate;
	}
	
	@RequestMapping("determineScheme.novo")
	@ResponseBody
	public String determineScheme(int id,String[] goodsId,String[] supplierId,String[] buyNum,HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		userBuySchemeService.determineScheme(id, goodsId, supplierId, buyNum, user);
		return "success";
	}
	
	@RequestMapping("jumpSchemeDetails.novo")
	@ResponseBody
	public ModelAndView jumpSchemeDetails(int id,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("schemeDetails");
		request.setAttribute("id", id);
		return mv;
	}
	
	@RequestMapping("schemeDetails.novo")
	@ResponseBody
	public PageBean schemeDetails(int id,int pageNo,int pageSize,HttpServletRequest request) {
		PageBean pb = userBuySchemeService.getListOfChildScheme(id, pageNo, pageSize);
		return pb;
	}
	
	@RequestMapping("jumpChildSchemeDetails.novo")
	@ResponseBody
	public ModelAndView childSchemeDetails(int id,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("childSchemeDetails");
		request.setAttribute("id", id);
		return mv;
	}
	
	@RequestMapping("childSchemeDetails.novo")
	@ResponseBody
	public PageBean childSchemeDetails(int id,String comName,int pageNo,int pageSize) {
		return buySchemeService.getList(id, comName, pageNo, pageSize);
	}
	
	@RequestMapping("showNoBuy.novo")
	@ResponseBody
	public NoBuyDto showNoBuy(int id) {
		UserBuySchemeEntity ubs = userBuySchemeService.getById(id);
		return buySchemeService.getNoBuyGoods(buyPlanService.getListOfRe(ubs.getUbp().getId()), buySchemeService.getListById(id));
	}
	@RequestMapping("showBuy.novo")
	@ResponseBody
	public List<BuySchemeEntity> showBuy(int id) {
		
		return buySchemeService.getListByIdOfBuy(id);
	}
	
	@RequestMapping("delUserBuyScheme.novo")
	@ResponseBody
	public String delUserBuyScheme(int id) {
		
		userBuySchemeService.delById(id);
		
		return "success";
	}
	
	@RequestMapping("submitScheme.novo")
	@ResponseBody
	public String submitScheme(int id,HttpServletRequest request) {
		UserBuySchemeEntity ubs = userBuySchemeService.getById(id);
		ubs.setState("1");
		ubs.setSubTime(d.getString(new Date()));
		userBuySchemeService.updata(ubs);
		return "1";
	}
	@RequestMapping("exportBuyGoodsExcel.novo")
	@ResponseBody
	public String exportBuyGoodsExcel(HttpServletResponse response,int id) {
		response.setContentType("application/binary;charset=UTF-8");
		try{
            ServletOutputStream out=response.getOutputStream();
            try {
                //设置文件头：最后一个参数是设置下载文件名(这里我们叫：张三.pdf)
                response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode("商品数据.xls", "UTF-8"));
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
         
            String[] titles = { "erp编码", "通用名", "规格", "批准文号", "生产厂家", "采购数量", "采购价格", "供应商"}; 
            exportExcel.exportBuyGoods(titles, out,buySchemeService.getListByIdOfBuy(id));      
            return "success";
        } catch(Exception e){
            e.printStackTrace();
            return "导出信息失败";
        }
    }
	
	
}
