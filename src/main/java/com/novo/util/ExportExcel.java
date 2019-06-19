package com.novo.util;

import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.novo.entity.BuySchemeEntity;

public class ExportExcel {
	public void export(String[] titles, ServletOutputStream out) throws Exception {
		try {
			// 第一步，创建一个workbook，对应一个Excel文件
			HSSFWorkbook workbook = new HSSFWorkbook();

			// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
			HSSFSheet hssfSheet = workbook.createSheet("sheet1");

			// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short

			HSSFRow row = hssfSheet.createRow(0);
			// 第四步，创建单元格，并设置值表头 设置表头居中
			HSSFCellStyle hssfCellStyle = workbook.createCellStyle();

			// 居中样式
			hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

			HSSFCell hssfCell = null;
			for (int i = 0; i < titles.length; i++) {
				hssfCell = row.createCell(i);// 列索引从0开始
				hssfCell.setCellValue(titles[i]);// 列名1
				hssfCell.setCellStyle(hssfCellStyle);// 列居中显示
			}

			// // 第五步，写入实体数据
			// Person person1=new Person("1","张三","123","26");
			// Person person2=new Person("2","李四","123","18");
			// Person person3=new Person("3","王五","123","77");
			// Person person4=new Person("4","徐小筱","123","1");

			// //这里我把list当做数据库啦
			// ArrayList<Person> list=new ArrayList<Person>();
			// list.add(person1);
			// list.add(person2);
			// list.add(person3);
			// list.add(person4);
			//
			// for (int i = 0; i < list.size(); i++) {
			// row = hssfSheet.createRow(i+1);
			// Person person = list.get(i);
			//
			// // 第六步，创建单元格，并设置值
			// String id = null;
			// if(person.getId() != null){
			// id = person.getId();
			// }
			// row.createCell(0).setCellValue(id);
			// String name = "";
			// if(person.getName() != null){
			// name = person.getName();
			// }
			// row.createCell(1).setCellValue(name);
			// String password = "";
			// if(person.getPassword() != null){
			// password = person.getPassword();
			// }
			// row.createCell(2).setCellValue(password);
			// String age=null;
			// if(person.getAge() !=null){
			// age = person.getAge();
			// }
			// row.createCell(3).setCellValue(age);
			// }

			// 第七步，将文件输出到客户端浏览器
			try {
				workbook.write(out);
				out.flush();
				out.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("导出信息失败！");

		}
	}

	public void exportBuyGoods(String[] titles, ServletOutputStream out, List<BuySchemeEntity> list) throws Exception {
		try {
			// 第一步，创建一个workbook，对应一个Excel文件
			HSSFWorkbook workbook = new HSSFWorkbook();

			// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
			HSSFSheet hssfSheet = workbook.createSheet("sheet1");

			// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short

			HSSFRow row = hssfSheet.createRow(0);
			// 第四步，创建单元格，并设置值表头 设置表头居中
			HSSFCellStyle hssfCellStyle = workbook.createCellStyle();

			// 居中样式
			hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

			HSSFCell hssfCell = null;
			for (int i = 0; i < titles.length; i++) {
				hssfCell = row.createCell(i);// 列索引从0开始
				hssfCell.setCellValue(titles[i]);// 列名1
				hssfCell.setCellStyle(hssfCellStyle);// 列居中显示
			}

			// 第五步，写入实体数据

			for (int i = 0; i < list.size(); i++) {
				row = hssfSheet.createRow(i + 1);
				BuySchemeEntity buySchem = list.get(i);

				// 第六步，创建单元格，并设置值
				String erpNo = "";
				if (buySchem.getErpNo() != null) {
					erpNo = buySchem.getErpNo();
				}
				row.createCell(0).setCellValue(erpNo);
				String comName = "";
				if (buySchem.getComName() != null) {
					comName = buySchem.getComName();
				}
				row.createCell(1).setCellValue(comName);
				String spec = "";
				if (buySchem.getSpec() != null) {
					spec = buySchem.getSpec();
				}
				row.createCell(2).setCellValue(spec);
				String licenseNo = "";
				if (buySchem.getLicenseNo() != null) {
					licenseNo = buySchem.getLicenseNo();
				}
				row.createCell(3).setCellValue(licenseNo);
				String produceFact = "";
				if (buySchem.getProduceFact() != null) {
					produceFact = buySchem.getProduceFact();
				}
				row.createCell(4).setCellValue(produceFact);
				int reBuyNum = 0;
				if (buySchem.getReBuyNum() != 0) {
					reBuyNum = buySchem.getReBuyNum();
				}
				row.createCell(5).setCellValue(reBuyNum);
				float price = 0;
				if (buySchem.getPrice() != 0) {
					price = buySchem.getPrice();
				}
				row.createCell(6).setCellValue(price);
				String name = "";
				if (buySchem.getSupp().getName() != null) {
					name = buySchem.getSupp().getName();
				}
				row.createCell(7).setCellValue(name);
			}

			// 第七步，将文件输出到客户端浏览器
			try {
				workbook.write(out);
				out.flush();
				out.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("导出信息失败！");

		}
	}

}
