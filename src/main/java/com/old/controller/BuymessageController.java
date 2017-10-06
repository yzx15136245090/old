package com.old.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.old.model.Buymessage;
import com.old.model.Goods;
import com.old.service.BuymessageService;

@Controller
public class BuymessageController {
	@Resource
	BuymessageService buymessageService;
	
	@RequestMapping("/releaseBuymessage")
	public String ReleaseBuymessage(Buymessage buymessage,HttpServletRequest request,HttpSession session) {
		
		 buymessageService.ReleaseBuymessage(buymessage,request,session);
		 return "redirect:/index/firstPage.jsp";
	}
	//查询发布状态下的求购信息
	//@ResponseBody
	//@RequestMapping("/allBuymessage0")
	//public List<Buymessage> allBuymessage0() {
	// buymessageService.allBuymessage(0);
	//}
	//查询过期状态下的求购信息

	@RequestMapping("/allBuymessage1")
	public List<Buymessage> allBuymessage1() {
		return buymessageService.allBuymessage(1);
	}
	@RequestMapping("/allBuymessage0")
	public String allBuymessage0(HttpSession session,Model model,int startPage,int  pageSize) {
		List<Buymessage> buymessageList=buymessageService.allBuymessage(0, startPage, pageSize);
		int totalPages = buymessageService.findBuymessageNumber(0); //
		model.addAttribute("buymessageList", buymessageList);
		model.addAttribute("totalPages", (totalPages/pageSize)+(totalPages%pageSize==0?0:1));
       
		return "buymessageData";
	}
}
