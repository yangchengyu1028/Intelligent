package com.novo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novo.dao.BuySchemeDao;
import com.novo.dto.NoBuyDto;
import com.novo.entity.BuyPlanEntity;
import com.novo.entity.BuySchemeEntity;
import com.novo.entity.PostBuyScheme;
import com.novo.service.IBuySchemeService;
import com.novo.util.PageBean;
@Service("buySchemeService")
public class BuySchemeServiceImpl implements IBuySchemeService{
	@Autowired
	private BuySchemeDao buySchemeDao;

	@Override
	public PageBean getList(int id, String comName, int pageNo, int pageSize) {
		int totalNum = (int) getTotalNum(id,comName);
		PageBean pb = new PageBean(pageNo, pageSize, totalNum);
		List<String> list = new ArrayList<String>();
		String hql = "from BuySchemeEntity bs where bs.childScheme.id="+id;
		if(comName != null&&!"".equals(comName)) {
			hql += " and bs.comName like ? ";
			list.add("%"+comName+"%");
		}
		List<BuySchemeEntity> list1 = buySchemeDao.getListPageObject(hql, list, pb.getNum(), pageSize);
		pb.setList(list1);
		return pb;
	}

	@Override
	public long getTotalNum(int id, String comName) {
		List<String> list = new ArrayList<String>();
		String hql = "select count(*) from BuySchemeEntity bs where bs.childScheme.id="+id;
		if(comName != null&&!"".equals(comName)) {
			hql += " and bs.comName like ? ";
			list.add("%"+comName+"%");
		}
		return buySchemeDao.getListAllNums(hql, list);
	}

	@Override
	public List<BuySchemeEntity> getListById(int id) {
		String hql = "from BuySchemeEntity bs where bs.childScheme.ubs.id="+id;
		return buySchemeDao.getListObject(hql);
	}
	@Override
	public List<BuySchemeEntity> getListByIdOfBuy(int id){
		String hql = "from BuySchemeEntity bs where bs.reBuyNum !=0 and bs.childScheme.ubs.id="+id;
		return buySchemeDao.getListObject(hql);
	}

	@Override
	public NoBuyDto getNoBuyGoods(List<BuyPlanEntity> list1, List<BuySchemeEntity> list2) {
		NoBuyDto nb = new NoBuyDto();
		List<BuyPlanEntity> list3 = new ArrayList<BuyPlanEntity>();
		List<Integer> list4 = new ArrayList<Integer>();
		for(int i=0;i<list1.size();i++) {
			int planNum = list1.get(i).getBuyNum();
			for(int j=0;j<list2.size();j++) {
				if(list1.get(i).getErpNo().equals(list2.get(j).getErpNo())) {
					planNum -= list2.get(j).getReBuyNum();
				}
			}
			if(planNum>0) {
				list3.add(list1.get(i));
				list4.add(planNum);
			}
		}
		nb.setList1(list3);
		nb.setList2(list4);
		return nb;
	}

	@Override
	public List<PostBuyScheme> getAllBuyScheme(int id) {
		String hql = "from BuySchemeEntity bs where bs.childScheme.ubs.id="+id;
		List<PostBuyScheme> list1 = new ArrayList<PostBuyScheme>();
		List<BuySchemeEntity> list = buySchemeDao.getListObject(hql);
		
		for (BuySchemeEntity buySchemeEntity : list) {
			PostBuyScheme pb = new PostBuyScheme();
			pb.setPost_id(buySchemeEntity.getId());
			pb.setGoods_name(buySchemeEntity.getComName());
			pb.setMarket_price(buySchemeEntity.getPrice());
			pb.setGoods_number(buySchemeEntity.getReBuyNum());
			list1.add(pb);
		}
		return list1;
	}

	@Override
	public BuySchemeEntity getByGoodsSn(int id) {
		
		return buySchemeDao.getByIdObject(id);
	}

	@Override
	public void updata(BuySchemeEntity bs) {
		buySchemeDao.updateObject(bs);
		
	}

	@Override
	public List<BuySchemeEntity> getUnpurchased(int id) {
		String hql = "from BuySchemeEntity where planBuyNum-reBuyNum!=0 AND childScheme.ubs.id="+id;
		return buySchemeDao.getListObject(hql);
	}
	
	
}
