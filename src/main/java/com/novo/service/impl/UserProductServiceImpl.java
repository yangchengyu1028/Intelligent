package com.novo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.novo.dao.UserProductDao;
import com.novo.entity.UserEntity;
import com.novo.entity.UserProductEntity;
import com.novo.service.ICloudGoodsService;
import com.novo.service.IUserProductService;
import com.novo.util.DateToString;
import com.novo.util.PageBean;
import com.novo.vo.GoodsVo;

@Service("userProductService")
public class UserProductServiceImpl implements IUserProductService {
	@Autowired
	private UserProductDao userProductDao;
	@Autowired
	private ICloudGoodsService cloudGoodsService;
	private DateToString d;

	@Override
	public PageBean getList(GoodsVo goods, int pageNo, int pageSize,UserEntity user) {
		int totalNum = (int) getTotalNum(goods,user);
		PageBean pb = new PageBean(pageNo, pageSize, totalNum);
		List<String> list = new ArrayList<String>();
		String hql = "from UserProductEntity up where up.user.id="+user.getId();
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
		if (goods.getBarCode() != null && !"".equals(goods.getBarCode())) {
			hql += " and up.barCode like ? ";
			list.add("%" + goods.getBarCode() + "%");
		}
		if (goods.getDrug() != null && !"".equals(goods.getDrug())) {
			hql += " and up.drug like ? ";
			list.add("%" + goods.getDrug() + "%");
		}
		if (goods.getErpNo() != null && !"".equals(goods.getErpNo())) {
			hql += " and up.erpNo like ? ";
			list.add("%" + goods.getErpNo() + "%");
		}
		if (goods.getSignError() != null && !"".equals(goods.getSignError())) {
			hql += " and up.signError like ? ";
			list.add("%" + goods.getSignError() + "%");
		}
		if (goods.getRelaState() != null && !"".equals(goods.getRelaState())) {
			hql += " and up.relaState = ? ";
			list.add(goods.getRelaState());
		}
		List<UserProductEntity> list0 = userProductDao.getListPageObject(hql, list, pb.getNum(), pageSize);
		pb.setList(list0);

		return pb;
	}

	@Override
	public long getTotalNum(GoodsVo goods,UserEntity user) {
		List<String> list = new ArrayList<String>();
		String hql = "select count(*) from UserProductEntity up where up.user.id="+user.getId();
		if (goods.getComName() != null && !"".equals(goods.getComName())) {
			hql += " and up.relaState like ? ";
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
		if (goods.getBarCode() != null && !"".equals(goods.getBarCode())) {
			hql += " and up.barCode like ? ";
			list.add("%" + goods.getBarCode() + "%");
		}
		if (goods.getDrug() != null && !"".equals(goods.getDrug())) {
			hql += " and up.drug like ? ";
			list.add("%" + goods.getDrug() + "%");
		}
		if (goods.getErpNo() != null && !"".equals(goods.getErpNo())) {
			hql += " and up.erpNo like ? ";
			list.add("%" + goods.getErpNo() + "%");
		}
		if (goods.getSignError() != null && !"".equals(goods.getSignError())) {
			hql += " and up.signError like ? ";
			list.add("%" + goods.getSignError() + "%");
		}
		if (goods.getRelaState() != null && !"".equals(goods.getRelaState())) {
			hql += " and up.relaState = ? ";
			list.add(goods.getRelaState());
		}
		long totalNum = userProductDao.getListAllNums(hql, list);

		return totalNum;
	}

	@Override
	public void add(UserProductEntity upd) {

		userProductDao.sava(upd);

	}

	@Override
	public void updateSignError(String[] checkID, String radio) {
		
		for(int i=0;i<checkID.length;i++) {
			UserProductEntity upe = userProductDao.getByIdObject(Integer.parseInt(checkID[i]));
			upe.setSignError(radio);
			userProductDao.updateObject(upe);
		}
		
	}
	
	public void delUserProduct(String[] checkID) {
		
		for(int i=0;i<checkID.length;i++) {
			userProductDao.delByIdObject(Integer.parseInt(checkID[i]));
		}
		
	}

	@Override
	public UserProductEntity getById(int id) {
		UserProductEntity user = userProductDao.getByIdObject(id);
		return user;
	}

	@Override
	public void update(UserProductEntity upe) {
		
		userProductDao.updateObject(upe);
		
	}

	@Override
	public void delete(UserProductEntity upe) {
		
		userProductDao.delete(upe);
		
	}

	@Override
	public int getNumOfRele(UserEntity user) {
		String hql = "select count(*) from UserProductEntity upe where upe.relaState = '1' and upe.user.id="+user.getId();
		return userProductDao.getTotalNum2(hql);
	}

	@Override
	public int getNumOfNoRele(UserEntity user) {
		String hql = "select count(*) from UserProductEntity upe where upe.relaState != '1' and upe.user.id="+user.getId();
		return userProductDao.getTotalNum2(hql);
	}
	
	@Override
	public UserProductEntity query0(String erpNo,UserEntity user) {

		List<String> list = new ArrayList<String>();
		String hql = "from UserProductEntity up where up.erpNo=? and up.user.id="+user.getId();
		list.add(erpNo);
		return userProductDao.findObject(hql, list);
	}

	@Override
	public UserProductEntity query(String erpNo,UserEntity user) {

		List<String> list = new ArrayList<String>();
		String hql = "from UserProductEntity up where up.relaState='1' and up.erpNo=? and up.user.id="+user.getId();
		list.add(erpNo);
		return userProductDao.findObject(hql, list);
	}

	@Override
	public List<UserProductEntity> getOfNoRele(UserEntity user) {
		String hql = "from UserProductEntity upe where upe.relaState != '1' and upe.user.id="+user.getId();
		return userProductDao.getListObject(hql);
	}


	@Override
	public UserProductEntity exist(String erpNo, UserEntity user) {
		List<String> list = new ArrayList<String>();
		String hql = "from UserProductEntity up where up.erpNo=? and up.user.id="+user.getId();
		list.add(erpNo);
		return userProductDao.findObject(hql, list);
	}
	
}
