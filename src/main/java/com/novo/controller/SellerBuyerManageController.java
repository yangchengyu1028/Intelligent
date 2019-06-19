package com.novo.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.novo.util.ExportExcel;
import com.novo.service.IUserSupplierService;

@Controller
public class SellerBuyerManageController {
	
	@Autowired
	private IUserSupplierService userSupplierService;
	
	private ExportExcel exportExcel = new ExportExcel();
	
	@RequestMapping("SellerBuyerManage.novo")
	public String supplierManage(HttpSession session) {
		if(null==session.getAttribute("supplier")) {
			return "login";
		}
		
		return "SellerBuyerManage";
	}
	
	@RequestMapping("exportSellGoodsExcel.novo")
	@ResponseBody
	public String exportSellGoodsExcel(HttpServletResponse response) {
		response.setContentType("application/binary;charset=UTF-8");
		try{
            ServletOutputStream out=response.getOutputStream();
            try {
                //设置文件头：最后一个参数是设置下载文件名(这里我们叫：张三.pdf)
                response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode("商品数据模板（所有单元格不能为空）.xls", "UTF-8"));
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
         
            String[] titles = { "erp编码", "通用名", "规格", "生产厂家", "批准文号", "条形码", "库存", "价格" , "效期", "有效期（时间段）", "生产日期", "中包装"}; 
            exportExcel.export(titles, out);      
            return "success";
        } catch(Exception e){
            e.printStackTrace();
            return "导出信息失败";
        }
    }

	@RequestMapping("exportNoSellGoodsExcel.novo")
	@ResponseBody
	public String exportNoSellGoodsExcel(HttpServletResponse response) {
		response.setContentType("application/binary;charset=UTF-8");
		try{
            ServletOutputStream out=response.getOutputStream();
            try {
                //设置文件头：最后一个参数是设置下载文件名(这里我们叫：张三.pdf)
                response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode("不可售商品数据（所有单元格不能为空）.xls", "UTF-8"));
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
         
            String[] titles = { "erp编码"}; 
            exportExcel.export(titles, out);      
            return "success";
        } catch(Exception e){
            e.printStackTrace();
            return "导出信息失败";
        }
    }
	
}
