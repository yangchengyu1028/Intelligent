package com.novo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novo.dao.CloudGoodsSupplierDao;
import com.novo.entity.CloudGoodsEntity;
import com.novo.entity.CloudGoodsSupplierEntity;
import com.novo.entity.SupplierEntity;
import com.novo.entity.UserEntity;
import com.novo.service.ICloudGoodsSupplierService;
import com.novo.util.PageBean;
import com.novo.vo.AllProductVo;
import com.novo.vo.ProductVo;
@Service
public class CloudGoodsSupplierServiceImpl implements ICloudGoodsSupplierService{
	@Autowired
	private CloudGoodsSupplierDao cloudGoodsSupplierDao;

	@Override
	public CloudGoodsSupplierEntity exist(CloudGoodsSupplierEntity cgs) {
		
		String hql = "from CloudGoodsSupplierEntity cgs where cgs.supp.id="+cgs.getSupp().getId()+" and cgs.sellerProId='"+cgs.getSellerProId()+"'";
		CloudGoodsSupplierEntity list = cloudGoodsSupplierDao.findObject(hql);
		
		
		return list;
	}

	@Override
	public void save(CloudGoodsSupplierEntity cgs) {
		CloudGoodsSupplierEntity cgs1 = exist(cgs);
		if(null == cgs1) {
			cloudGoodsSupplierDao.sava(cgs);
		}else {
			cgs1.setBarCode(cgs.getBarCode());
			cgs1.setBasicState(cgs.getBasicState());
			cgs1.setComName(cgs.getComName());
			cgs1.setExpiration_date(cgs.getExpiration_date());
			cgs1.setExpiryDate(cgs.getExpiryDate());
			cgs1.setGoods(cgs.getGoods());
			cgs1.setGoods_packing(cgs.getGoods_packing());
			cgs1.setLicenseNo(cgs.getLicenseNo());
			cgs1.setPrice(cgs.getPrice());
			cgs1.setProduceFact(cgs.getProduceFact());
			cgs1.setProductiontime(cgs.getProductiontime());
			cgs1.setSellerProId(cgs.getSellerProId());
			cgs1.setSpec(cgs.getSpec());
			cgs1.setState(cgs.getState());
			cgs1.setStock(cgs.getStock());
			cgs1.setSupp(cgs.getSupp());
			cgs1.setUpdatePrice(cgs.getUpdatePrice());
			cloudGoodsSupplierDao.updateObject(cgs1);
		}
		
		
	}

	@Override
	public void update(CloudGoodsSupplierEntity cgs) {
		cloudGoodsSupplierDao.updateObject(cgs);
	}

	@Override
	public int getAllNum(SupplierEntity supp) {
		String hql = "select count(*) from CloudGoodsSupplierEntity cgs where cgs.state=1 and cgs.supp.id="+supp.getId();
		return cloudGoodsSupplierDao.getTotalNum2(hql);
	}

	@Override
	public PageBean getList(ProductVo goods, int pageNo, int pageSize, SupplierEntity supplier) {
		int totalNum = (int) getTotalNum(goods,supplier);
		PageBean pb = new PageBean(pageNo, pageSize, totalNum);
		List<String> list = new ArrayList<String>();
		String hql = "from CloudGoodsSupplierEntity up where up.supp.id="+supplier.getId();
		if (goods.getComName() != null && !"".equals(goods.getComName())) {
			hql += " and up.comName like ? ";
			list.add("%" + goods.getComName() + "%");
		}
		if (goods.getSpec() != null && !"".equals(goods.getSpec())) {
			hql += " and up.spec like ? ";
			list.add("%" + goods.getSpec() + "%");
		}
		if (goods.getProduceFact() != null && !"".equals(goods.getProduceFact())) {
			hql += " and up.produceFact like ? ";
			list.add("%" + goods.getProduceFact() + "%");
		}
		if (goods.getLicenseNo() != null && !"".equals(goods.getLicenseNo())) {
			hql += " and up.licenseNo like ? ";
			list.add("%" + goods.getLicenseNo() + "%");
		}
		if (goods.getSellerProId() != null && !"".equals(goods.getSellerProId())) {
			hql += " and up.sellerProId like ? ";
			list.add("%" + goods.getSellerProId() + "%");
		}
		hql += " and up.state ="+goods.getState();
		List<CloudGoodsSupplierEntity> list0 = cloudGoodsSupplierDao.getListPageObject(hql, list, pb.getNum(), pageSize);
		pb.setList(list0);

		return pb;
	}

	@Override
	public long getTotalNum(ProductVo goods, SupplierEntity supplier) {
		List<String> list = new ArrayList<String>();
		String hql = "select count(*) from CloudGoodsSupplierEntity up where up.supp.id="+supplier.getId();
		if (goods.getComName() != null && !"".equals(goods.getComName())) {
			hql += " and up.comName like ? ";
			list.add("%" + goods.getComName() + "%");
		}
		if (goods.getSpec() != null && !"".equals(goods.getSpec())) {
			hql += " and up.spec like ? ";
			list.add("%" + goods.getSpec() + "%");
		}
		if (goods.getProduceFact() != null && !"".equals(goods.getProduceFact())) {
			hql += " and up.produceFact like ? ";
			list.add("%" + goods.getProduceFact() + "%");
		}
		if (goods.getLicenseNo() != null && !"".equals(goods.getLicenseNo())) {
			hql += " and up.licenseNo like ? ";
			list.add("%" + goods.getLicenseNo() + "%");
		}
		if (goods.getSellerProId() != null && !"".equals(goods.getSellerProId())) {
			hql += " and up.sellerProId like ? ";
			list.add("%" + goods.getSellerProId() + "%");
		}
		hql += " and up.state ="+goods.getState();
		long totalNum = cloudGoodsSupplierDao.getListAllNums(hql, list);

		return totalNum;
	}

	@Override
	public CloudGoodsSupplierEntity getById(int id) {
		// TODO Auto-generated method stub
		return cloudGoodsSupplierDao.getByIdObject(id);	
	}
	
	@Override
	public PageBean getAllList(AllProductVo goods, int pageNo, int pageSize) {
		int totalNum = (int) getAllTotalNum(goods);
		PageBean pb = new PageBean(pageNo, pageSize, totalNum);
		List<String> list = new ArrayList<String>();
		String hql = "from CloudGoodsSupplierEntity up where 1=1";
		if (goods.getComName() != null && !"".equals(goods.getComName())) {
			hql += " and up.comName like ? ";
			list.add("%" + goods.getComName() + "%");
		}
		if (goods.getSpec() != null && !"".equals(goods.getSpec())) {
			hql += " and up.spec like ? ";
			list.add("%" + goods.getSpec() + "%");
		}
		if (goods.getProduceFact() != null && !"".equals(goods.getProduceFact())) {
			hql += " and up.produceFact like ? ";
			list.add("%" + goods.getProduceFact() + "%");
		}
		if (goods.getLicenseNo() != null && !"".equals(goods.getLicenseNo())) {
			hql += " and up.licenseNo like ? ";
			list.add("%" + goods.getLicenseNo() + "%");
		}
		if (goods.getSellerProId() != null && !"".equals(goods.getSellerProId())) {
			hql += " and up.sellerProId like ? ";
			list.add("%" + goods.getSellerProId() + "%");
		}
		if (goods.getSupplierName() != null && !"".equals(goods.getSupplierName())) {
			hql += " and up.supp.name like ? ";
			list.add("%" + goods.getSupplierName() + "%");
		}
		hql += " and up.basicState ="+goods.getState();
		List<CloudGoodsSupplierEntity> list0 = cloudGoodsSupplierDao.getListPageObject(hql, list, pb.getNum(), pageSize);
		pb.setList(list0);

		return pb;
	}

	@Override
	public long getAllTotalNum(AllProductVo goods) {
		List<String> list = new ArrayList<String>();
		String hql = "select count(*) from CloudGoodsSupplierEntity up where 1=1";
		if (goods.getComName() != null && !"".equals(goods.getComName())) {
			hql += " and up.comName like ? ";
			list.add("%" + goods.getComName() + "%");
		}
		if (goods.getSpec() != null && !"".equals(goods.getSpec())) {
			hql += " and up.spec like ? ";
			list.add("%" + goods.getSpec() + "%");
		}
		if (goods.getProduceFact() != null && !"".equals(goods.getProduceFact())) {
			hql += " and up.produceFact like ? ";
			list.add("%" + goods.getProduceFact() + "%");
		}
		if (goods.getLicenseNo() != null && !"".equals(goods.getLicenseNo())) {
			hql += " and up.licenseNo like ? ";
			list.add("%" + goods.getLicenseNo() + "%");
		}
		if (goods.getSellerProId() != null && !"".equals(goods.getSellerProId())) {
			hql += " and up.sellerProId like ? ";
			list.add("%" + goods.getSellerProId() + "%");
		}
		if (goods.getSupplierName() != null && !"".equals(goods.getSupplierName())) {
			hql += " and up.supp.name like ? ";
			list.add("%" + goods.getSupplierName() + "%");
		}
		hql += " and up.basicState ="+goods.getState();
		long totalNum = cloudGoodsSupplierDao.getListAllNums(hql, list);

		return totalNum;
	}

	@Override
	public List<CloudGoodsSupplierEntity> getBySuppAndCloudGoods(CloudGoodsEntity entity, List<SupplierEntity> list) {
		List<CloudGoodsSupplierEntity> list2 = new ArrayList<>();
		String hql = "";
		List<CloudGoodsSupplierEntity> list3 = new ArrayList<>();
		for(int i=0,j=list.size();i<j;i++) {
			hql = "From CloudGoodsSupplierEntity where goods.id="+entity.getId()+" and supp.id="+list.get(i).getId();
			list3 = cloudGoodsSupplierDao.getListObject(hql);
			if(null==list3||list3.isEmpty()) {
				list2.add(null);
			}else {
				list2.add(list3.get(0));
			}
		}
		
		return list2;
	}

	@Override
	public CloudGoodsSupplierEntity getBysellerProIdAndSupplier(String sellerProId, SupplierEntity supp) {
		String hql = "From CloudGoodsSupplierEntity where sellerProId="+sellerProId+" and supp.id="+supp.getId();
		return cloudGoodsSupplierDao.findObject(hql);
	}


}
