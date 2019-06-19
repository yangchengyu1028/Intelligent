package com.novo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novo.dao.CloudGoodsDao;
import com.novo.entity.BuyPlanEntity;
import com.novo.entity.CloudGoodsEntity;
import com.novo.entity.CloudGoodsSupplierEntity;
import com.novo.entity.UserProductEntity;
import com.novo.service.ICloudGoodsService;
import com.novo.util.GetNumByString;
@Service
public class CloudGoodsServiceImpl implements ICloudGoodsService {
	@Autowired
	private CloudGoodsDao cloudGoodsDao;
	private GetNumByString getNumByString = new GetNumByString();
	
	@Override
	public List<CloudGoodsEntity> query(List<String> list) {
		
		String hql = "from CloudGoodsEntity cge where comName like ? and produceFact like ? and licenseNo like ? and spec like ?";

		return cloudGoodsDao.getListObject(hql, list);
	}

	@Override
	public CloudGoodsEntity getById(int id) {
		
		return cloudGoodsDao.loadByIdObject(id);
	}

	@Override
	public List<CloudGoodsEntity> ready(List<String> list) {
		
		String hql = "from CloudGoodsEntity cge where comName = ? and produceFact = ? and licenseNo = ?";
		
		return cloudGoodsDao.getListObject(hql, list);
	}

	@Override
	public List<CloudGoodsEntity> getList(List<BuyPlanEntity> list) {
		List<CloudGoodsEntity> list1 = new ArrayList<CloudGoodsEntity>();
		for (BuyPlanEntity buyPlanEntity : list) {
			String hql = "from CloudGoodsEntity cge where cge.id="+buyPlanEntity.getUserProduce().getGoods().getId();;
			CloudGoodsEntity goods = cloudGoodsDao.findObject(hql);
			if(null==goods) {
				continue;
			}
			list1.add(goods);
		}
		return list1;
	}

	@Override
	public CloudGoodsEntity relevance(UserProductEntity up) {
		String specNum = getNumByString.getNum(up.getSpec());
		String hql = "from CloudGoodsEntity cge where cge.licenseNo = ? and cge.specDroduct = ?";
		List<String> list = new ArrayList<String>();	
		list.add(up.getLicenseNo());
		list.add(specNum);
		List<CloudGoodsEntity> list0 = cloudGoodsDao.getListObject(hql, list);
		if(list0.isEmpty()) {
			return null;
		}
		
		return list0.get(0);
	}
	@Override
	public CloudGoodsEntity relevanceByQuanZhi(UserProductEntity up) {
		String hql = "from CloudGoodsEntity cge where cge.comName = ? and cge.spec = ? and cge.produceFact = ?";
		List<String> list = new ArrayList<String>();	
		list.add(up.getComName());
		list.add(up.getSpec());
		list.add(up.getProduceFact());
		List<CloudGoodsEntity> list0 = cloudGoodsDao.getListObject(hql, list);
		if(list0.isEmpty()) {
			return null;
		}
		
		return list0.get(0);
	}

	@Override
	public void save(CloudGoodsEntity cg) {
		
		cloudGoodsDao.sava(cg);
		
	}

	@Override
	public void updata(CloudGoodsEntity cg) {
		
		cloudGoodsDao.updateObject(cg);
		
	}

	@Override
	public Object getLastTime() {
		String hql = "select max(c.uptime) from CloudGoodsEntity c ";
		return cloudGoodsDao.getMax(hql);
	}

	@Override
	public CloudGoodsEntity getByID(int id) {
		// TODO Auto-generated method stub
		return cloudGoodsDao.getByIdObject(id);
	}

	@Override
	public List<CloudGoodsEntity> get(int i) {
		return cloudGoodsDao.getListObject(i, 1000);
	}

	@Override
	public CloudGoodsEntity getByPronum(String pronum) {
		String hql = "from CloudGoodsEntity cge where cge.pronum='"+pronum+"'";
		return cloudGoodsDao.findObject(hql);
	}

	@Override
	public CloudGoodsEntity getByLicenseNo(String licenseNo,String specDroduct) {
		List<CloudGoodsEntity> list = new ArrayList<>();
		String hql = "from CloudGoodsEntity cge where cge.licenseNo='"+licenseNo+"' and cge.specDroduct='"+specDroduct+"'";
		list = cloudGoodsDao.getListObject(hql);
		if(list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public CloudGoodsEntity getByThree(CloudGoodsSupplierEntity cloudGoodsSupplierEntity) {
		String hql = "from CloudGoodsEntity cge where cge.comName = ? and cge.spec = ? and cge.produceFact = ?";
		List<String> list = new ArrayList<String>();	
		list.add(cloudGoodsSupplierEntity.getComName());
		list.add(cloudGoodsSupplierEntity.getSpec());
		list.add(cloudGoodsSupplierEntity.getProduceFact());
		List<CloudGoodsEntity> list0 = cloudGoodsDao.getListObject(hql, list);
		if(list0.isEmpty()) {
			return null;
		}
		
		return list0.get(0);
	}

}
