package com.novo.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.novo.entity.BuyPlanEntity;
import com.novo.entity.CloudGoodsEntity;
import com.novo.entity.CloudGoodsSupplierEntity;
import com.novo.entity.SupplierEntity;
import com.novo.entity.UserBuyPlanEntity;
import com.novo.entity.UserEntity;
import com.novo.entity.UserProductEntity;
import com.novo.service.IBuyPlanService;
import com.novo.service.ICloudGoodsService;
import com.novo.service.ICloudGoodsSupplierService;
import com.novo.service.IUserBuyPlanService;
import com.novo.service.IUserProductService;
import com.novo.util.DateToString;
import com.novo.util.GetNumByString;
import com.novo.util.ImportExcelUtil;

@Controller

public class UploadExcelControl {

	@Autowired
	private IUserProductService userProductService;
	@Autowired
	private IUserBuyPlanService userBuyPlanService;
	@Autowired
	private IBuyPlanService buyPlanService;
	@Autowired
	private ICloudGoodsService cloudGoodsService;
	@Autowired
	private ICloudGoodsSupplierService cloudGoodsSupplierService;
	private GetNumByString getNumByString = new GetNumByString();
	private DateToString d = new DateToString();

	@RequestMapping("localGoodsExcel.novo")
	public String localGoodsExcel(@RequestParam("file") MultipartFile file, HttpServletRequest request)
			throws Exception {
		if (!file.isEmpty()) {
			try {
				// 这里将上传得到的文件保存指定目录下
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File("D:\\upload\\localgoodsfile\\",
						System.currentTimeMillis() + file.getOriginalFilename()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		InputStream in = null;

		List<List<Object>> listob = null;

		in = file.getInputStream();

		listob = new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename());

		// 该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
		try {
			HttpSession session = request.getSession(false);
			UserEntity user = (UserEntity) session.getAttribute("user");
			DateToString d = new DateToString();
			UserProductEntity upe = null;
			CloudGoodsEntity upe1 = null;
			for (int i = 0; i < listob.size(); i++) {

				List<Object> lo = listob.get(i);

				upe = new UserProductEntity();
				upe.setErpNo(String.valueOf(lo.get(0)));

				if (userProductService.exist(upe.getErpNo(), user) == null) {
					upe.setComName(String.valueOf(lo.get(1)));
					upe.setSpec(String.valueOf(lo.get(2)));
					upe.setDrug(String.valueOf(lo.get(3)));
					upe.setUnit(String.valueOf(lo.get(4)));
					upe.setProduceFact(String.valueOf(lo.get(5)));
					upe.setBarCode(String.valueOf(lo.get(6)));
					upe.setLicenseNo(String.valueOf(lo.get(7)));

					upe.setUser(user);
					// 接下来与平台商品进行关联后存入本地数据库
					upe.setRelaState("0");
					upe.setSignError("0");
					// 判断
					if (upe.getLicenseNo().contains("国药准字")) {
						upe1 = cloudGoodsService.relevance(upe);
						if (upe1 != null) {
							upe.setRelaState("1");
							upe.setGoods(upe1);
							upe.setRelaTime(d.getString(new Date()));
							userProductService.add(upe);
						} else {
							userProductService.add(upe);
						}
					} else {
						upe1 = cloudGoodsService.relevanceByQuanZhi(upe);
						if (upe1 != null) {
							upe.setRelaState("1");
							upe.setGoods(upe1);
							upe.setRelaTime(d.getString(new Date()));
							userProductService.add(upe);
						} else {
							upe.setRelaState("0");
							userProductService.add(upe);
						}
					}
					upe1 = null;
				} else {
					continue;
				}

			}
		} catch (Exception e) {
			return "2";
		}

		return "1";
	}

	@RequestMapping("buyPlan.novo")
	@ResponseBody
	public String buyPlan(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {

		if (!file.isEmpty()) {

			try {

				// 这里将上传得到的文件保存指定目录下

				FileUtils.copyInputStreamToFile(file.getInputStream(),

						new File("D:\\upload\\buyplanfile\\", System.currentTimeMillis() + file.getOriginalFilename()));

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

		InputStream in = null;

		List<List<Object>> listob = null;

		in = file.getInputStream();

		listob = new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename());
		try {
			// 该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
			HttpSession session = request.getSession(false);
			UserEntity user = (UserEntity) session.getAttribute("user");
			UserBuyPlanEntity ubp = new UserBuyPlanEntity();
			Date date = new Date();

			ubp.setPlanTime(d.getStringTime(date));
			ubp.setUser(user);
			ubp.setState("0");
			ubp.setName(file.getOriginalFilename());
			userBuyPlanService.save(ubp);
			UserBuyPlanEntity userBuyPlanEntity = userBuyPlanService.query(d.getStringTime(date), user);
			int tolNum = 0;
			BuyPlanEntity bpe = null;
			UserProductEntity upe = null;
			for (int i = 0; i < listob.size(); i++) {

				List<Object> lo = listob.get(i);
				
				bpe = new BuyPlanEntity();
				bpe.setComName(String.valueOf(lo.get(0)));
				bpe.setSpec(String.valueOf(lo.get(1)));
				bpe.setProduceFact(String.valueOf(lo.get(2)));
				bpe.setLicenseNo(String.valueOf(lo.get(3)));
				bpe.setBarCode(String.valueOf(lo.get(4)));
				bpe.setDrug(String.valueOf(lo.get(5)));
				bpe.setUnit(String.valueOf(lo.get(6)));
				bpe.setErpNo(String.valueOf(lo.get(7)));
				bpe.setEvaluate(Float.parseFloat(String.valueOf(lo.get(8))));
				bpe.setBuyNum(Integer.parseInt(String.valueOf(lo.get(9))));

				bpe.setUserBuyPlan(userBuyPlanEntity);

				// 接下来与本地商品库进行关联后存入本地数据库
				upe = userProductService.query(String.valueOf(lo.get(7)), user);
				if (upe != null) {
					bpe.setUserProduce(upe);
					bpe.setState("1");
				} else {
					bpe.setState("0");
				}
				buyPlanService.save(bpe);
				tolNum += 1;
			}
			userBuyPlanEntity.setTotalGoods(tolNum);
			userBuyPlanService.update(userBuyPlanEntity);
			upe = null;

		} catch (Exception e) {
			return "2";
		}

		return "1";
	}

	@RequestMapping("importSellGoodstExcel.novo")
	@ResponseBody
	public String importSellGoodstExcel(@RequestParam("file") MultipartFile file, HttpServletRequest request)
			throws Exception {

		if (!file.isEmpty()) {

			try {

				// 这里将上传得到的文件保存指定目录下

				FileUtils.copyInputStreamToFile(file.getInputStream(),

						new File("D:\\upload\\sellGoodsfile\\",
								System.currentTimeMillis() + file.getOriginalFilename()));

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

		InputStream in = null;

		List<List<Object>> listob = null;

		in = file.getInputStream();

		listob = new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename());
		try {
			// 该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
			HttpSession session = request.getSession(false);
			SupplierEntity supp = (SupplierEntity) session.getAttribute("supplier");
			// 创建上游商家商品实体，循环注入并与基本库匹配保存到商家商品库
			CloudGoodsSupplierEntity cloudGoodsSupplierEntity = null;
			for (int i = 0; i < listob.size(); i++) {
				List<Object> lo = listob.get(i);
				
				cloudGoodsSupplierEntity = new CloudGoodsSupplierEntity();
				cloudGoodsSupplierEntity.setSellerProId(String.valueOf(lo.get(0)));
				cloudGoodsSupplierEntity.setComName(String.valueOf(lo.get(1)));
				cloudGoodsSupplierEntity.setSpec(String.valueOf(lo.get(2)));
				cloudGoodsSupplierEntity.setProduceFact(String.valueOf(lo.get(3)));
				cloudGoodsSupplierEntity.setLicenseNo(String.valueOf(lo.get(4)));
				cloudGoodsSupplierEntity.setBarCode(String.valueOf(lo.get(5)));
				cloudGoodsSupplierEntity.setStock(Integer.parseInt(String.valueOf(lo.get(6))));
				cloudGoodsSupplierEntity.setPrice(String.valueOf(lo.get(7)));
				cloudGoodsSupplierEntity.setExpiryDate(String.valueOf(lo.get(8)));
				cloudGoodsSupplierEntity.setExpiration_date(String.valueOf(lo.get(9)));
				cloudGoodsSupplierEntity.setProductiontime(String.valueOf(lo.get(10)));
				cloudGoodsSupplierEntity.setGoods_packing(String.valueOf(lo.get(11)));
				cloudGoodsSupplierEntity.setState(1);
				cloudGoodsSupplierEntity.setUpdatePrice("9999.00");
				cloudGoodsSupplierEntity.setSupp(supp);

				// 接下来与商品基本库库进行关联后存入本地数据库
				if (cloudGoodsSupplierEntity.getLicenseNo().contains("国药准字")) {
					CloudGoodsEntity cloudGoodsEntity = cloudGoodsService.getByLicenseNo(
							cloudGoodsSupplierEntity.getLicenseNo(),
							getNumByString.getNum(cloudGoodsSupplierEntity.getSpec()));
					if (null == cloudGoodsEntity) {
						cloudGoodsSupplierEntity.setBasicState(0);
						cloudGoodsSupplierService.save(cloudGoodsSupplierEntity);
					} else {
						cloudGoodsSupplierEntity.setGoods(cloudGoodsEntity);
						cloudGoodsSupplierEntity.setBasicState(1);
						cloudGoodsSupplierService.save(cloudGoodsSupplierEntity);
					}
				} else {
					CloudGoodsEntity cloudGoodsEntity = cloudGoodsService.getByThree(cloudGoodsSupplierEntity);
					if (null == cloudGoodsEntity) {
						cloudGoodsSupplierEntity.setBasicState(0);
						cloudGoodsSupplierService.save(cloudGoodsSupplierEntity);
					} else {
						cloudGoodsSupplierEntity.setGoods(cloudGoodsEntity);
						cloudGoodsSupplierEntity.setBasicState(1);
						cloudGoodsSupplierService.save(cloudGoodsSupplierEntity);
					}

				}
			}
		} catch (Exception e) {
			return "2";
		}

		return "1";
	}

	@RequestMapping("importNoSellGoodstExcel.novo")
	@ResponseBody
	public String importNoSellGoodstExcel(@RequestParam("file") MultipartFile file, HttpServletRequest request)
			throws Exception {

		if (!file.isEmpty()) {

			try {

				// 这里将上传得到的文件保存指定目录下

				FileUtils.copyInputStreamToFile(file.getInputStream(),

						new File("D:\\upload\\noSellGoodsfile\\",
								System.currentTimeMillis() + file.getOriginalFilename()));

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

		InputStream in = null;

		List<List<Object>> listob = null;

		in = file.getInputStream();

		listob = new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename());
		try {
			// 该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
			HttpSession session = request.getSession(false);
			SupplierEntity supp = (SupplierEntity) session.getAttribute("supplier");
			// 创建上游商家商品实体，循环注入并与基本库匹配保存到商家商品库
			CloudGoodsSupplierEntity cloudGoodsSupplierEntity = null;
			String sellerProId = "";
			for (int i = 0; i < listob.size(); i++) {
				List<Object> lo = listob.get(i);
				
				sellerProId = String.valueOf(lo.get(0));

				// 接下来通过商家和商家内部商品编码找到该商品
				cloudGoodsSupplierEntity = cloudGoodsSupplierService.getBysellerProIdAndSupplier(sellerProId, supp);
				cloudGoodsSupplierEntity.setState(0);
				cloudGoodsSupplierService.update(cloudGoodsSupplierEntity);
			}
		} catch (Exception e) {
			return "2";
		}

		return "1";
	}

}