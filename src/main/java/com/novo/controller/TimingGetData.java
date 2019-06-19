package com.novo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.novo.entity.CloudGoodsEntity;
import com.novo.entity.CloudGoodsSupplierEntity;
import com.novo.entity.UserSupplierEntity;
import com.novo.service.ICloudGoodsService;
import com.novo.service.ICloudGoodsSupplierService;
import com.novo.service.IUserSupplierService;
import com.novo.util.GetAndPost;
import com.novo.util.GetNumByString;


@Controller
public class TimingGetData {
	
	@Autowired
	private ICloudGoodsService cloudGoodsService;
	@Autowired
	private IUserSupplierService userSupplierService;
	@Autowired
	private ICloudGoodsSupplierService cloudGoodsSupplierService;
	private String token = null;
	private Date testDate = null;
	private GetAndPost getAndPost = new GetAndPost();
	private GetNumByString getNumByString = new GetNumByString();
	
			
	
	// 定时获取更新基本库商品
	public synchronized void execute1() {
		
		String url = "http://basepro.bioey.com/bioapi/bioapi_gateway.aspx?method=api.post.product.list";
		int page = -1;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("access_token", drawMoney());
		map.put("pagesize", 50);
		map.put("isauditstatus", false);
		map.put("procode", "");
		map.put("prodos", "");
		map.put("proent", "");
		map.put("proname", "");
		map.put("propkid", "");
		map.put("propycode", "");
		map.put("prospec", "");
		while(true) {
			page++;
			map.put("pageindex", page);
			String json = getAndPost.postData(url, map);
			JSONObject job = JSONObject.parseObject(json);
			if(job.getIntValue("code")!=0) {
				continue;
			}
			JSONArray jsonArray = job.getJSONArray("items");
			if(jsonArray.isEmpty()) {
				break;
			}
			for(int i=0;i<jsonArray.size();i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				CloudGoodsEntity cloudGoodsEntity = new CloudGoodsEntity();
				String barCode = jsonObject.getString("procode");
				String comName = jsonObject.getString("proname");
				String licenseNo = jsonObject.getString("protit");
				String produceFact = jsonObject.getString("proent");
				String pronum = jsonObject.getString("pronum");
				String spec = jsonObject.getString("prospec");
				cloudGoodsEntity.setBarCode(barCode);
				cloudGoodsEntity.setComName(comName);
				cloudGoodsEntity.setLicenseNo(licenseNo);
				cloudGoodsEntity.setProduceFact(produceFact);
				cloudGoodsEntity.setPronum(pronum);
				cloudGoodsEntity.setSpec(spec);
				try {
					cloudGoodsEntity.setSpecDroduct(getNumByString.getNum(spec));
				} catch (Exception e) {
					// TODO: handle exception
					//e.printStackTrace();
				}
				CloudGoodsEntity cloudGoodsEntity2 = cloudGoodsService.getByPronum(pronum);
				if(null==cloudGoodsEntity2) {
					cloudGoodsService.save(cloudGoodsEntity);
				}else {
					try {
						if(!cloudGoodsEntity2.getComName().equals(comName)||!cloudGoodsEntity2.getSpecDroduct().equals(cloudGoodsEntity.getSpecDroduct())) {
							cloudGoodsEntity2.setBarCode(cloudGoodsEntity.getBarCode());
							cloudGoodsEntity2.setComName(cloudGoodsEntity.getComName());
							cloudGoodsEntity2.setLicenseNo(cloudGoodsEntity.getLicenseNo());
							cloudGoodsEntity2.setProduceFact(cloudGoodsEntity.getProduceFact());
							cloudGoodsEntity2.setPronum(cloudGoodsEntity.getPronum());
							cloudGoodsEntity2.setSpec(cloudGoodsEntity.getSpec());
							cloudGoodsEntity2.setSpecDroduct(cloudGoodsEntity.getSpecDroduct());
							cloudGoodsService.updata(cloudGoodsEntity2);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
					
				}
				
				
			}
			
		}
		
	}
	// 定时计算每个商家的的可售商品
	public synchronized void execute2() {
		List<UserSupplierEntity> list = userSupplierService.getAll();
		for (UserSupplierEntity userSupplierEntity : list) {
			userSupplierEntity.setCount(cloudGoodsSupplierService.getAllNum(userSupplierEntity.getSupplier()));
			userSupplierService.updataOfNum(userSupplierEntity);
		}	
	}

	/**
     * 获取access_token密匙
     * @return  access_token
     */
    public String getAccesstoken() {
    	//测试
        //String url = "http://basepro.bioey.com/bioapi/bioapi_gateway.aspx?method=api.get.token.detail&appid=701aa98b41ce4d3f8de7faef5d77f5eb&appsecret=d1b18bd476a24be199e963e0d136513e";
    	String url = "http://basepro.bioey.com/bioapi/bioapi_gateway.aspx?method=api.get.token.detail&appid=459142cfadc54f08bda0a116df3957e3&appsecret=a21fb75373594cca8ab2a92d652b8a6b";
    	String json = getAndPost.get(url);
        JSONObject job = JSONObject.parseObject(json);
        String access_token = job.getString("access_token");
        return access_token;
    }
    /**
     * 获取密钥
     * @return
     */
    public synchronized String drawMoney() {
        if(token==null) {
            token = getAccesstoken();
            testDate = new Date();
        }else {
            Date date = new Date();
            if ((testDate.getTime() + 1*60*60*1000) < date.getTime()) {
                token = getAccesstoken();
                testDate = date;
            }
        }
        return	token;
    }
	@RequestMapping("postBasicGoods.novo")
	@ResponseBody
	public String postBasicGoods(int id) {
		CloudGoodsSupplierEntity cloudGoodsSupplierEntity = cloudGoodsSupplierService.getById(id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("access_token", drawMoney());
		map.put("prosource", "104");//申请来源id
		map.put("proname", cloudGoodsSupplierEntity.getComName());//通用名
		map.put("proent", cloudGoodsSupplierEntity.getProduceFact());//生产企业
		map.put("prospec", cloudGoodsSupplierEntity.getSpec());//规格
		map.put("protit", cloudGoodsSupplierEntity.getLicenseNo());//批准文号
		map.put("procode", cloudGoodsSupplierEntity.getBarCode());//条形码
		String url = "http://basepro.bioey.com/bioapi/bioapi_gateway.aspx?method=api.set.medicine.add";
		String str = getAndPost.postData(url, map);
		JSONObject jsonObject = JSONObject.parseObject(str);
		if(jsonObject.getIntValue("code")==0) {
			CloudGoodsEntity cloudGoodsEntity = new CloudGoodsEntity();
			cloudGoodsEntity.setComName(cloudGoodsSupplierEntity.getComName());
			cloudGoodsEntity.setBarCode(cloudGoodsSupplierEntity.getBarCode());
			cloudGoodsEntity.setLicenseNo(cloudGoodsSupplierEntity.getLicenseNo());
			cloudGoodsEntity.setProduceFact(cloudGoodsSupplierEntity.getProduceFact());
			cloudGoodsEntity.setSpec(cloudGoodsSupplierEntity.getSpec());
			try {
				cloudGoodsEntity.setSpecDroduct(getNumByString.getNum(cloudGoodsSupplierEntity.getSpec()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			cloudGoodsService.save(cloudGoodsEntity);
			return "1";
		}
		return "0";
	}
}
