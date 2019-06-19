package com.novo.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.novo.entity.CloudGoodsEntity;
import com.novo.entity.CloudGoodsSupplierEntity;
import com.novo.service.ICloudGoodsService;
import com.novo.service.ICloudGoodsSupplierService;
import com.novo.service.ISupplierService;
import com.novo.util.GetNumByString;

@Controller
@RequestMapping("/interface")
public class InterfacesController {
	
	@Autowired
	private ICloudGoodsService cloudGoodsService;
	@Autowired
	private ISupplierService supplierService;
	@Autowired
	private ICloudGoodsSupplierService cloudGoodsSupplierService;
	private GetNumByString getNumByString = new GetNumByString();
	

    @RequestMapping(value="/saveSupplierGoods.novo",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> saveSupplierGoods(@RequestBody String json){
    	Map<String,Object> map = new HashMap<>();
        JSONObject jsonObject =  JSONObject.parseObject(json);
        if(!jsonObject.containsKey("data")) {
        	CloudGoodsSupplierEntity cloudGoodsSupplierEntity = new CloudGoodsSupplierEntity();
            String spec = "";
            int stock = 0;
            if(jsonObject.containsKey("goodsId")) {
            	if("".equals(jsonObject.getString("goodsId"))) {
            		map.put("code", 500);
                	map.put("msg", "goodsId不能为空!");
                	return map;
            	}
            	cloudGoodsSupplierEntity.setSellerProId(jsonObject.getString("goodsId"));
            }else {
            	map.put("code", 500);
            	map.put("msg", "goodsId不能为空!");
            	return map;
            }
            if(jsonObject.containsKey("spec")) {
            	if("".equals(jsonObject.getString("spec"))) {
            		map.put("code", 500);
                	map.put("msg", "spec不能为空!");
                	return map;
            	}
            	spec = jsonObject.getString("spec").trim();
            }else {
            	map.put("code", 500);
            	map.put("msg", "spec不能为空!");
            	return map;
            }
            cloudGoodsSupplierEntity.setSpec(spec);
            
            if(jsonObject.containsKey("comName")) {
            	if("".equals(jsonObject.getString("comName"))) {
            		map.put("code", 500);
                	map.put("msg", "comName不能为空!");
                	return map;
            	}
            	cloudGoodsSupplierEntity.setComName(jsonObject.getString("comName").trim());
            }else {
            	map.put("code", 500);
            	map.put("msg", "comName不能为空!");
            	return map;
            }
            if(jsonObject.containsKey("produceFact")) {
            	if("".equals(jsonObject.getString("produceFact"))) {
            		map.put("code", 500);
                	map.put("msg", "produceFact不能为空!");
                	return map;
            	}
            	cloudGoodsSupplierEntity.setProduceFact(jsonObject.getString("produceFact").trim());
            }else {
            	map.put("code", 500);
            	map.put("msg", "produceFact不能为空!");
            	return map;            
            }
            if(jsonObject.containsKey("licenseNo")) {
            	if("".equals(jsonObject.getString("licenseNo"))) {
            		map.put("code", 500);
                	map.put("msg", "licenseNo不能为空!");
                	return map;
            	}
            	cloudGoodsSupplierEntity.setLicenseNo(jsonObject.getString("licenseNo").trim());
            }else {
            	map.put("code", 500);
            	map.put("msg", "licenseNo不能为空!");
            	return map;  
            }
            if(jsonObject.containsKey("barCode")) {
            	cloudGoodsSupplierEntity.setBarCode(jsonObject.getString("barCode").trim().trim());
            }else {
            	cloudGoodsSupplierEntity.setBarCode("");
            }
            if(jsonObject.containsKey("price")) {
            	if("".equals(jsonObject.getString("price"))) {
            		map.put("code", 500);
                	map.put("msg", "price不能为空!");
                	return map;
            	}
            	cloudGoodsSupplierEntity.setPrice(jsonObject.getString("price"));
            }else {
            	map.put("code", 500);
            	map.put("msg", "price不能为空!");
            	return map;
            }
            if(jsonObject.containsKey("expiryDate")) {
            	cloudGoodsSupplierEntity.setExpiryDate(jsonObject.getString("expiryDate")); 
            }else {
            	cloudGoodsSupplierEntity.setExpiryDate(""); 
            }
            if(jsonObject.containsKey("expiration_date")) {
            	cloudGoodsSupplierEntity.setExpiration_date(jsonObject.getString("expiration_date"));
            }else {
            	cloudGoodsSupplierEntity.setExpiration_date(""); 
            }
            if(jsonObject.containsKey("productiontime")) {
            	cloudGoodsSupplierEntity.setProductiontime(jsonObject.getString("productiontime"));
            }else {
            	cloudGoodsSupplierEntity.setProductiontime(""); 
            }
            if(jsonObject.containsKey("supplierId")) {
            	cloudGoodsSupplierEntity.setSupp(supplierService.getById(jsonObject.getIntValue("supplierId")));
            }else {
            	map.put("code", 500);
            	map.put("msg", "supplierId不能为空!");
            	return map;
            }
            if(jsonObject.containsKey("goodsPacking")) {
            	cloudGoodsSupplierEntity.setGoods_packing(jsonObject.getString("goodsPacking").trim());
            }else {
            	cloudGoodsSupplierEntity.setGoods_packing(""); 
            }
            
            if(jsonObject.containsKey("stock")) {
            	stock = jsonObject.getIntValue("stock");
            }else {
            	map.put("code", 500);
            	map.put("msg", "stock不能为空!");
            	return map;
            }

            if(stock<0) {
            	cloudGoodsSupplierEntity.setStock(0);
            }else {
            	cloudGoodsSupplierEntity.setStock(stock);
            }
            cloudGoodsSupplierEntity.setUpdatePrice("9999.00");
            cloudGoodsSupplierEntity.setState(1);
            
            CloudGoodsSupplierEntity cloudGoodsSupplierEntity1 = cloudGoodsSupplierService.exist(cloudGoodsSupplierEntity);

            if(null==cloudGoodsSupplierEntity1) {
            	if(cloudGoodsSupplierEntity.getLicenseNo().contains("国药准字")) {
                	CloudGoodsEntity cloudGoodsEntity = cloudGoodsService.getByLicenseNo(cloudGoodsSupplierEntity.getLicenseNo(), getNumByString.getNum(spec));
                	if(null==cloudGoodsEntity) {
                		cloudGoodsSupplierEntity.setBasicState(0);
                		cloudGoodsSupplierService.save(cloudGoodsSupplierEntity);
                	}else {
                		cloudGoodsSupplierEntity.setGoods(cloudGoodsEntity);
                		cloudGoodsSupplierEntity.setBasicState(1);
                		cloudGoodsSupplierService.save(cloudGoodsSupplierEntity);
                	}
                }else {
                	CloudGoodsEntity cloudGoodsEntity = cloudGoodsService.getByThree(cloudGoodsSupplierEntity);
                	if(null==cloudGoodsEntity) {
                		cloudGoodsSupplierEntity.setBasicState(0);
                		cloudGoodsSupplierService.save(cloudGoodsSupplierEntity);
                	}else {
                		cloudGoodsSupplierEntity.setGoods(cloudGoodsEntity);
                		cloudGoodsSupplierEntity.setBasicState(1);
                		cloudGoodsSupplierService.save(cloudGoodsSupplierEntity);
                	}
                	
                }
            }else {
            	if(!cloudGoodsSupplierEntity1.getPrice().equals(cloudGoodsSupplierEntity.getPrice())||cloudGoodsSupplierEntity1.getStock()!=cloudGoodsSupplierEntity.getStock()) {
            		cloudGoodsSupplierEntity1.setPrice(cloudGoodsSupplierEntity.getPrice());
            		cloudGoodsSupplierEntity1.setStock(cloudGoodsSupplierEntity.getStock());
            		cloudGoodsSupplierService.update(cloudGoodsSupplierEntity1);
            		map.put("code", 200);
                	map.put("msg", "已存在,修改成功!");
                	return map;
            	}
            }
            
            map.put("code", 200);
        	map.put("msg", "操作成功!");
        	return map;
        }else {
        	JSONObject jsonObject2 = jsonObject.getJSONObject("data");
        	
        	int supplierId = 0;
        	JSONArray array = jsonObject2.getJSONArray("goodsArr");
        	if(jsonObject2.containsKey("supplierId")) {
        		supplierId = jsonObject2.getIntValue("supplierId");
            }else {
            	map.put("code", 500);
            	map.put("msg", "supplierId不能为空!");
            	return map;
            }
        	if(array.size()!=1&&array.size()!=10&&array.size()!=20) {
        		map.put("code", 500);
            	map.put("msg", "每次传送只能为1,10,20条商品数据!");
            	return map;
        	}
        	CloudGoodsSupplierEntity cloudGoodsSupplierEntity = null;
        	Set<String> set = new HashSet<>();
        	for(int i=0,j=array.size();i<j;i++) {
        		JSONObject jsonObject3 = array.getJSONObject(i);
        		cloudGoodsSupplierEntity = new CloudGoodsSupplierEntity();
        		String spec = "";
                int stock = 0;
                String goodsId = "";
                if(jsonObject3.containsKey("goodsId")) {
                	goodsId = jsonObject3.getString("goodsId");
                	if("".equals(goodsId)) {
                		continue;
                	}
                	cloudGoodsSupplierEntity.setSellerProId(goodsId);
                }else {
                	continue;
                }
                if(jsonObject3.containsKey("spec")) {
                	spec = jsonObject3.getString("spec").trim();
                	if("".equals(spec)) {
                		set.add(goodsId);
                		continue;
                	}
                }else {
                	set.add(goodsId);
                	continue;
                }
                cloudGoodsSupplierEntity.setSpec(spec);
                
                if(jsonObject3.containsKey("comName")) {
                	if("".equals(jsonObject3.getString("comName").trim())) {
                		set.add(goodsId);
                		continue;
                	}
                	cloudGoodsSupplierEntity.setComName(jsonObject3.getString("comName").trim());
                }else {
                	set.add(goodsId);
                	continue;
                }
                if(jsonObject3.containsKey("produceFact")) {
                	if("".equals(jsonObject3.getString("produceFact").trim())) {
                		set.add(goodsId);
                		continue;
                	}
                	cloudGoodsSupplierEntity.setProduceFact(jsonObject3.getString("produceFact").trim());
                }else {
                	set.add(goodsId);
                	continue;
                }

                if(jsonObject3.containsKey("licenseNo")) {
                	if("".equals(jsonObject3.getString("licenseNo").trim())) {
                		set.add(goodsId);
                		continue;
                	}
                	cloudGoodsSupplierEntity.setLicenseNo(jsonObject3.getString("licenseNo").trim());
                }else {
                	set.add(goodsId);
                	continue;
                }
                if(jsonObject3.containsKey("barCode")) {
                	cloudGoodsSupplierEntity.setBarCode(jsonObject3.getString("barCode").trim().trim());
                }else {
                	cloudGoodsSupplierEntity.setBarCode("");
                }
                if(jsonObject3.containsKey("price")) {
                	cloudGoodsSupplierEntity.setPrice(jsonObject3.getString("price"));
                }else {
                	set.add(goodsId);
                	continue;
                }
                if(jsonObject3.containsKey("expiryDate")) {
                	cloudGoodsSupplierEntity.setExpiryDate(jsonObject3.getString("expiryDate")); 
                }else {
                	cloudGoodsSupplierEntity.setExpiryDate(""); 
                }
                if(jsonObject3.containsKey("expiration_date")) {
                	cloudGoodsSupplierEntity.setExpiration_date(jsonObject3.getString("expiration_date"));
                }else {
                	cloudGoodsSupplierEntity.setExpiration_date(""); 
                }
                if(jsonObject3.containsKey("productiontime")) {
                	cloudGoodsSupplierEntity.setProductiontime(jsonObject3.getString("productiontime"));
                }else {
                	cloudGoodsSupplierEntity.setProductiontime(""); 
                }
                if(jsonObject3.containsKey("goodsPacking")) {
                	cloudGoodsSupplierEntity.setGoods_packing(jsonObject3.getString("goodsPacking").trim());
                }else {
                	cloudGoodsSupplierEntity.setGoods_packing(""); 
                }
                
                if(jsonObject3.containsKey("stock")) {
                	stock = jsonObject3.getIntValue("stock");
                }else {
                	set.add(goodsId);
                	continue;
                }

                if(stock<0) {
                	cloudGoodsSupplierEntity.setStock(0);
                }else {
                	cloudGoodsSupplierEntity.setStock(stock);
                }
                cloudGoodsSupplierEntity.setUpdatePrice("9999.00");
                cloudGoodsSupplierEntity.setState(1);
                cloudGoodsSupplierEntity.setSupp(supplierService.getById(supplierId));
                CloudGoodsSupplierEntity cloudGoodsSupplierEntity1 = cloudGoodsSupplierService.exist(cloudGoodsSupplierEntity);

                if(null==cloudGoodsSupplierEntity1) {
                	if(cloudGoodsSupplierEntity.getLicenseNo().contains("国药准字")) {
                    	CloudGoodsEntity cloudGoodsEntity = cloudGoodsService.getByLicenseNo(cloudGoodsSupplierEntity.getLicenseNo(), getNumByString.getNum(spec));
                    	if(null==cloudGoodsEntity) {
                    		cloudGoodsSupplierEntity.setBasicState(0);
                    		cloudGoodsSupplierService.save(cloudGoodsSupplierEntity);
                    	}else {
                    		cloudGoodsSupplierEntity.setGoods(cloudGoodsEntity);
                    		cloudGoodsSupplierEntity.setBasicState(1);
                    		cloudGoodsSupplierService.save(cloudGoodsSupplierEntity);
                    	}
                    }else {
                    	CloudGoodsEntity cloudGoodsEntity = cloudGoodsService.getByThree(cloudGoodsSupplierEntity);
                    	if(null==cloudGoodsEntity) {
                    		cloudGoodsSupplierEntity.setBasicState(0);
                    		cloudGoodsSupplierService.save(cloudGoodsSupplierEntity);
                    	}else {
                    		cloudGoodsSupplierEntity.setGoods(cloudGoodsEntity);
                    		cloudGoodsSupplierEntity.setBasicState(1);
                    		cloudGoodsSupplierService.save(cloudGoodsSupplierEntity);
                    	}
                    	
                    }
                }else {
                	if(!cloudGoodsSupplierEntity1.getPrice().equals(cloudGoodsSupplierEntity.getPrice())||cloudGoodsSupplierEntity1.getStock()!=cloudGoodsSupplierEntity.getStock()) {
                		cloudGoodsSupplierEntity1.setPrice(cloudGoodsSupplierEntity.getPrice());
                		cloudGoodsSupplierEntity1.setStock(cloudGoodsSupplierEntity.getStock());
                		cloudGoodsSupplierService.update(cloudGoodsSupplierEntity1);
                	}
                }
        		
        		
        	}
        	if(set.isEmpty()) {
        		map.put("code", 200);
            	map.put("msg", "操作成功!");
            	return map;
        	}
        	map.put("code", 200);
        	map.put("msg", "操作成功!但部分缺失必要字段,未成功插入!");
        	map.put("goodsIds", set.toString().substring(1,set.toString().length()-1));
        	return map;
        	
        }
        
        
    }
    
    	
}
