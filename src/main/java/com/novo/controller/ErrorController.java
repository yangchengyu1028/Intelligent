package com.novo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

	@RequestMapping("800")

	public String handle1(HttpServletRequest request){

		return "800";

	}

	@RequestMapping("804")

	public String handle2(HttpServletRequest request){

		return "804";

	}

	@RequestMapping("500")

	public String handle3(HttpServletRequest request){

		return "500";

	}
}
