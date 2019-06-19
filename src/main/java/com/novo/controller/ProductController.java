package com.novo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.novo.entity.CloudGoodsEntity;
import com.novo.entity.CloudGoodsSupplierEntity;
import com.novo.entity.SupplierEntity;
import com.novo.service.ICloudGoodsService;
import com.novo.service.ICloudGoodsSupplierService;
import com.novo.util.PageBean;
import com.novo.vo.AllProductVo;
import com.novo.vo.ProductVo;

@Controller
public class ProductController {
	@Autowired
	private ICloudGoodsSupplierService cloudGoodsSupplierService;
	@Autowired
	private ICloudGoodsService cloudGoodsService;
	@RequestMapping("sellerGoodsManage.novo")
	public String localGoods(HttpSession session) {
		if(null==session.getAttribute("supplier")) {
			return "login";
		}

		return "sellerGoodsManage";
	}
	@RequestMapping("getProduct.novo")
	@ResponseBody
	public PageBean getGoods(ProductVo goods, int pageNo, int pageSize,HttpSession session) {
		
		SupplierEntity user = (SupplierEntity) session.getAttribute("supplier");
		PageBean pageBean = cloudGoodsSupplierService.getList(goods, pageNo, pageSize,user);
		return pageBean;
	}
	@RequestMapping("getAllProduct.novo")
	@ResponseBody
	public PageBean getAllProduct(AllProductVo goods, int pageNo, int pageSize) {
		
		PageBean pageBean = cloudGoodsSupplierService.getAllList(goods, pageNo, pageSize);
		return pageBean;
	}
	
	@RequestMapping("updatePrice.novo")
	@ResponseBody
	public String updatePrice(int id,String updatePrice) {
		CloudGoodsSupplierEntity cloudGoodsSupplierEntity = cloudGoodsSupplierService.getById(id);
		cloudGoodsSupplierEntity.setUpdatePrice(updatePrice);
		cloudGoodsSupplierService.update(cloudGoodsSupplierEntity);
		return "1";
	}
	
	@RequestMapping("openGoods.novo")
	@ResponseBody
	public String openGoods(int id) {
		CloudGoodsSupplierEntity cloudGoodsSupplierEntity = cloudGoodsSupplierService.getById(id);
		cloudGoodsSupplierEntity.setState(1);
		cloudGoodsSupplierService.update(cloudGoodsSupplierEntity);
		return "1";
	}
	
	@RequestMapping("closeGoods.novo")
	@ResponseBody
	public String closeGoods(int id) {
		CloudGoodsSupplierEntity cloudGoodsSupplierEntity = cloudGoodsSupplierService.getById(id);
		cloudGoodsSupplierEntity.setState(0);
		cloudGoodsSupplierService.update(cloudGoodsSupplierEntity);
		return "1";
	}
	
	@RequestMapping("relevanceOfAdmin.novo")
	@ResponseBody
	public CloudGoodsSupplierEntity relevanceOfAdmin(int id) {
		
		return cloudGoodsSupplierService.getById(id);
	}
	@RequestMapping("relevanceQueryOfAdmin.novo")
	@ResponseBody
	public List<CloudGoodsEntity> relevanceQueryOfAdmin(String comName1,String produceFact1,String licenseNo1,String spec1){
		List<String> list =new ArrayList<String>();
		list.add("%"+comName1.trim()+"%");
		list.add("%"+produceFact1.trim()+"%");
		list.add("%"+licenseNo1.trim()+"%");
		list.add("%"+spec1.trim()+"%");
		return cloudGoodsService.query(list);
	}
	@RequestMapping("cancelRelevanceOfAll.novo")
	@ResponseBody
	public String cancelRelevanceOfAll(int id) {
		CloudGoodsSupplierEntity cloudGoodsSupplierEntity = cloudGoodsSupplierService.getById(id);
		cloudGoodsSupplierEntity.setBasicState(0);
		cloudGoodsSupplierService.update(cloudGoodsSupplierEntity);
		return "1";
	}
	@RequestMapping("relevanceOfAll.novo")
	@ResponseBody
	public String relevanceOfAll(int basicId,int productId) {
		CloudGoodsSupplierEntity cloudGoodsSupplierEntity = cloudGoodsSupplierService.getById(productId);
		cloudGoodsSupplierEntity.setBasicState(1);
		cloudGoodsSupplierEntity.setGoods(cloudGoodsService.getByID(basicId));
		cloudGoodsSupplierService.update(cloudGoodsSupplierEntity);
		return "1";
	}
}
