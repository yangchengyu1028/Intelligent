package com.novo.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CodeController {

	@RequestMapping("codeServlet.novo")
	@ResponseBody
	public void codeServlet(HttpServletResponse response,HttpServletRequest request) throws IOException {
		//先在内存里面创建一个图片对象,第一个参数宽度，第二个高度。第三个图片的类型
		BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
		
		//得到图片，用于在java平台上呈现一个二维图像
		Graphics2D g  = (Graphics2D) image.getGraphics();
		
		//设置图片的背景、文本之类的数据
		g.setColor(Color.GRAY);  //设置背景颜色
		g.fillRect(0, 0, 80, 20); //将背景填充到图片上面
		
		//往图片上面设置文本
		g.setColor(Color.ORANGE);    //设置字体颜色
		g.setFont(new Font("宋体",Font.BOLD,20)); // 字体的样式
		
		//获取到验证码保存到session对象
		String codeNum = getNum();
		HttpSession session = request.getSession();
		session.setAttribute("code", codeNum);
		g.drawString(codeNum, 10, 20);
		
		//告诉客户端不缓存服务器发送回来的内容
		response.setContentType("image/jpeg;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pargma", "no-cache");
		
		//将图片发送会客户端
		ImageIO.write(image, "jpg", response.getOutputStream());
	}
	public String getNum() {
		//产生一个随机数
		Random ran= new Random();
		String num = ran.nextInt(9999)+"";
		
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<4-num.length();i++) {
			sb.append("0");
		}
		return sb+num;
	}
}
