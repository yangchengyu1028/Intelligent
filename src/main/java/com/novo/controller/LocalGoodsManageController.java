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

import com.novo.dto.LocalGoodsComparePrice;
import com.novo.entity.CloudGoodsEntity;
import com.novo.entity.CloudGoodsSupplierEntity;
import com.novo.entity.SupplierEntity;
import com.novo.entity.UserEntity;
import com.novo.entity.UserProductEntity;
import com.novo.entity.UserSupplierEntity;
import com.novo.service.ICloudGoodsService;
import com.novo.service.ICloudGoodsSupplierService;
import com.novo.service.ISupplierService;
import com.novo.service.IUserProductService;
import com.novo.util.DateToString;
import com.novo.util.ExportExcel;
import com.novo.util.PageBean;
import com.novo.vo.GoodsVo;

@Controller
public class LocalGoodsManageController {

	@Autowired
	private IUserProductService userProductService;
	@Autowired
	private ICloudGoodsService cloudGoodsService;
	@Autowired
	private ISupplierService supplierService;
	@Autowired
	private ICloudGoodsSupplierService cloudGoodsSupplierService;
	private DateToString d = new DateToString();
	private ExportExcel exportExcel = new ExportExcel();
	
	@RequestMapping("localGoods.novo")
	public String localGoods(HttpSession session) {
		if(null==session.getAttribute("user")) {
			return "login";
		}

		return "localGoodsManage";
	}

	@RequestMapping("getGoods.novo")
	@ResponseBody
	public PageBean getGoods(GoodsVo goods, int pageNo, int pageSize,HttpSession session) {
		
		UserEntity user = (UserEntity) session.getAttribute("user");
		PageBean pageBean = userProductService.getList(goods, pageNo, pageSize,user);

		return pageBean;
	}
	
	@RequestMapping("addUserProduct.novo")
	@ResponseBody
	public String allUserProduct(UserProductEntity upe,HttpServletRequest request) {
		//这里与平台上的商品进行匹配，匹配完成后给这个商品附上关联状态
		upe.setRelaState("0");
		
		HttpSession session = request.getSession();
		UserEntity user = (UserEntity) session.getAttribute("user");
		upe.setUser(user);
		userProductService.add(upe);
		
		return "success";
	}
	
	@RequestMapping("allSignError.novo")
	@ResponseBody
	public String allSignError(String[] checkID,String radio) {
		if(checkID==null) {
			return "failure";
		}
		userProductService.updateSignError(checkID, radio);
		return "success";
	}
	
	@RequestMapping("delUserProduct.novo")
	@ResponseBody
	public String delUserProduct(String[] checkID) {
		if(checkID==null) {
			return "failure";
		}
		userProductService.delUserProduct(checkID);
		return "success";
	}
	
	@RequestMapping("relevance.novo")
	@ResponseBody
	public List<Object> relevance(int id) {
		
		UserProductEntity user = userProductService.getById(id);
		List<Object> list = new ArrayList<Object>();
		List<String> list1 = null;
		List<CloudGoodsEntity> list2 = null;
		if(user.getRelaState().equals("2")) {
			list1 = new ArrayList<String>();
			list1.add(user.getComName());
			list1.add(user.getProduceFact());
			list1.add(user.getLicenseNo());
			list2 = cloudGoodsService.ready(list1);
		}
		list.add(user);
		list.add(list2);
		return list;
	}
	
	@RequestMapping("relevanceQuery.novo")
	@ResponseBody
	public List<CloudGoodsEntity> relevanceQuery(String comName4,String produceFact4,String licenseNo4,String spec4){
		List<String> list =new ArrayList<String>();
		list.add("%"+comName4+"%");
		list.add("%"+produceFact4+"%");
		list.add("%"+licenseNo4+"%");
		list.add("%"+spec4+"%");
		return cloudGoodsService.query(list);
	}

	
	@RequestMapping("relevancing.novo")
	@ResponseBody
	public String relevancing(int id,int ownId) {
		UserProductEntity upe = userProductService.getById(ownId);
		CloudGoodsEntity cge = cloudGoodsService.getById(id);
		upe.setGoods(cge);
		upe.setRelaState("1");
		upe.setRelaTime(d.getString(new Date()));
		userProductService.update(upe);
		
		return "success";
	}
	
	@RequestMapping("signError.novo")
	@ResponseBody
	public String signError(int id,String radio) {
		UserProductEntity upe = userProductService.getById(id);
		upe.setSignError(radio);
		userProductService.update(upe);
		return "success";
	}
	
	@RequestMapping("delSignError.novo")
	@ResponseBody
	public String delSignError(int id) {
		UserProductEntity entity = userProductService.getById(id);
		entity.setSignError("0");
		userProductService.update(entity);
		
		return "success";
	}
	
	@RequestMapping("addOfOne.novo")
	@ResponseBody
	public String addOfOne(String erpNo,String comName,String spec,String produceFact,String licenseNo,String barCode,String drug,String unit,HttpServletRequest req) {
		HttpSession session = req.getSession();
		UserEntity user = (UserEntity) session.getAttribute("user");
		UserProductEntity up = new UserProductEntity();
		up.setErpNo(erpNo);
		up.setComName(comName);
		up.setSpec(spec);
		up.setProduceFact(produceFact);
		up.setLicenseNo(licenseNo);
		up.setBarCode(barCode);
		up.setDrug(drug);
		up.setUnit(unit);
		up.setUser(user);
		up.setRelaState("0");
		up.setSignError("0");
		if(userProductService.query(up.getErpNo(), user)==null) {
			if(cloudGoodsService.relevance(up)!=null) {
				up.setRelaState("1");
				up.setGoods(cloudGoodsService.relevance(up));
				up.setRelaTime(d.getString(new Date()));
				userProductService.add(up);	
			}else{
				userProductService.add(up);
			}
		}
		
		
		return "success";
	}
	@RequestMapping("localGoodsComparePrice.novo")
	public String localGoodsComparePrice(HttpSession session) {
		if(null==session.getAttribute("user")) {
			return "login";
		}
		return "localGoodsComparePrice";
	}
	@RequestMapping("getDataByLocalGoodsId.novo")
	@ResponseBody
	public LocalGoodsComparePrice getDataByLocalGoodsId(int id,HttpServletRequest request) {
		//查询需要比价的本地商品
		UserProductEntity entity = userProductService.getById(id);
		UserEntity user = (UserEntity) request.getSession().getAttribute("user");
		//查询该用户已关联匹配的上游商家
		List<UserSupplierEntity> userSuppList = supplierService.getListOfRe(user);
		List<SupplierEntity> suppList = new ArrayList<SupplierEntity>();
		for (UserSupplierEntity userSupplierEntity : userSuppList) {
			suppList.add(userSupplierEntity.getSupplier());
		}
		//通过该本地商品找到对应基础库商品，再通过基础库商品和已匹配的商家查出这些商家下的该商品并打包传给前台
		List<CloudGoodsSupplierEntity> list = cloudGoodsSupplierService.getBySuppAndCloudGoods(entity.getGoods(), suppList);
		LocalGoodsComparePrice userDate = new LocalGoodsComparePrice(entity, suppList, list);
		return userDate;
	}
	
	@RequestMapping("exportLocalGoodsExcel.novo")
	@ResponseBody
	public String exportLocalGoodsExcel(HttpServletResponse response) {
		response.setContentType("application/binary;charset=UTF-8");
		try{
            ServletOutputStream out=response.getOutputStream();
            try {
                //设置文件头：最后一个参数是设置下载文件名(这里我们叫：张三.pdf)
                response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode("本地商品数据模板（所有单元格不能为空）.xls", "UTF-8"));
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
         
            String[] titles = { "erp编码", "通用名", "规格", "剂型", "单位", "生产企业", "条码", "批准文号"}; 
            exportExcel.export(titles, out);      
            return "success";
        } catch(Exception e){
            e.printStackTrace();
            return "导出信息失败";
        }
    }
}
