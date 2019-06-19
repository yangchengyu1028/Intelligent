package com.novo.util;

import java.util.ArrayList;
import java.util.List;

public class GetNumByString {
	/**
	 * 剔出字符串中数字并得到他们的乘积
	 * @param a
	 * @return
	 */
	public String getNum(String a) {
		char[] b = a.toCharArray();
		List<Double> list = new ArrayList<Double>();
		for (int i = 0; i < b.length; i++){
			String result = "";
			if (("0123456789.").indexOf(b[i] + "") != -1){
				result += b[i];
				for(int j=i+1;j<b.length;j++) {
					if (("0123456789.").indexOf(b[j] + "") != -1){
						result += b[j];
						i = j;
					}else {
						break;
					}
				}
				
				if(!".".equals(result)) {
					if(".".equals(result.substring(result.length()-1, result.length()))) {
						result = result.substring(0,result.length()-1);
					}else if(".".equals(result.substring(0, 1))) {
						result =  result.substring(1,result.length());
					}
					try {
						list.add(Double.parseDouble(result));
					}catch (Exception e){
						return "0";
					}

				}
			}
		}
		Double d = 1.0;
		for (int i=0;i<list.size();i++) {
				d = d*list.get(i);
			
		}
		String ss = String.format("%1.2f", d);
		return ss;
	}

}
