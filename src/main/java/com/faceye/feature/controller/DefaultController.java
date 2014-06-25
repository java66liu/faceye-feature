package com.faceye.feature.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @author @haipenge 
 * haipenge@gmail.com
*  Create Date:2014年5月18日
 */
@Controller
@RequestMapping("/default")
@Scope("prototype")
public class DefaultController {
	@RequestMapping(value="/index")
	public String index(){
		return "default.manager";
	}
	
	public String error(){
		return "";
	}
}
