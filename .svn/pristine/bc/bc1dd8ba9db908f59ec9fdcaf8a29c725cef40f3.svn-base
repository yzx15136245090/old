package com.old.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.old.model.Ident;
import com.old.model.Tip;
import com.old.service.IdentService;
import com.old.service.UserService;
 @Controller
 @RequestMapping(value = "/ident")
public class IdentContoller {
	@Autowired
	IdentService indservice;
	UserService userService;
	@RequestMapping(value = "/InserIdent", method = { RequestMethod.POST })

	public String InserIdent(String college,
			String school,String stuId, String stuName,
			@RequestParam("file") MultipartFile stuphono,HttpServletRequest request,HttpSession session) {
			  indservice.InserIdent(college,school,stuId,stuName,stuphono,request,session);
		
			return "redirect:/index/userCenter.jsp";
	}
	@RequestMapping(value = "/selectallfrom", method = { RequestMethod.POST })
	@ResponseBody
	public String slectallfrom(Model model,@RequestParam(value="page", defaultValue="1")Integer page,HttpSession session,HttpServletRequest request) {
		//List<Tip>  slectrep= reService.selectallre();
		List<Ident> pList=indservice.selectLimitLengthIs10((page - 1) * 10 + 1);
		int cownLength = indservice.querycowntall();
		model.addAttribute("report",pList);
		int __len =(int) Math.ceil(cownLength/10.0); 
		model.addAttribute("pageLength", __len);
		model.addAttribute("currPage", page);
		
		return "guanli/stuvalidate.jsp";	
	}
	@RequestMapping(value = "/selectallfrom1", method = { RequestMethod.POST })
	@ResponseBody
	public String slectallfrom1(Model model,@RequestParam(value="page", defaultValue="1")Integer page,HttpSession session,HttpServletRequest request) {
		//IdentStatus=1
		List<Ident> pList=indservice.selectLimitLengthIs101((page - 1) * 10 + 1,1);
		int cownLength = indservice.querycowntall1(1);
		model.addAttribute("report",pList);
		int __len =(int) Math.ceil(cownLength/10.0); 
		model.addAttribute("pageLength", __len);
		model.addAttribute("currPage", page);
		
		return "guanli/stuvalidate0.jsp";	
	}
	@RequestMapping(value = "/selectallfrom2", method = { RequestMethod.POST })
	@ResponseBody
	public String slectallfrom2(Model model,@RequestParam(value="page", defaultValue="1")Integer page,HttpSession session,HttpServletRequest request) {
		//IdentStatus=0
		List<Ident> pList=indservice.selectLimitLengthIs101((page - 1) * 10 + 1,0);
		int cownLength = indservice.querycowntall1(0);
		model.addAttribute("report",pList);
		int __len =(int) Math.ceil(cownLength/10.0); 
		model.addAttribute("pageLength", __len);
		model.addAttribute("currPage", page);
		
		return "guanli/stuvalidate1.jsp";	
	}
	@RequestMapping(value = "/selectallfrom3", method = { RequestMethod.POST })
	@ResponseBody
	public String slectallfrom3(Model model,@RequestParam(value="page", defaultValue="1")Integer page,HttpSession session,HttpServletRequest request) {
		//IdentStatus=2
		List<Ident> pList=indservice.selectLimitLengthIs101((page - 1) * 10 + 1,2);
		int cownLength = indservice.querycowntall1(2);
		model.addAttribute("report",pList);
		int __len =(int) Math.ceil(cownLength/10.0); 
		model.addAttribute("pageLength", __len);
		model.addAttribute("currPage", page);
		
		return "guanli/stuvalidate2.jsp";	
	}
	
	@RequestMapping(value = "/selectallfroman", method = { RequestMethod.POST })
	@ResponseBody
	public String selectallfroman(Model model,String search,@RequestParam(value="page", defaultValue="1")Integer page,HttpSession session,HttpServletRequest request) {
		//IdentStatus=2
		List<Ident> pList=indservice.selectLimitLengthIs102((page - 1) * 10 + 1,search);
		int cownLength = indservice.querycowntall2(search);
		model.addAttribute("report",pList);
		int __len =(int) Math.ceil(cownLength/10.0); 
		model.addAttribute("pageLength", __len);
		model.addAttribute("currPage", page);
		
		return "guanli/stuvalidate3.jsp";	
	}
	
	@RequestMapping(value = "/updentstud", method = { RequestMethod.POST })
	@ResponseBody
	public String updentstud(Model model,String identid,HttpSession session,HttpServletRequest request) {
		//IdentStatus=2
		indservice.updentstud(identid,1);
	
		return "guanli/stuvalidate.jsp";	
	}
	@RequestMapping(value = "/updentstud1", method = { RequestMethod.POST })
	@ResponseBody
	public String updentstud1(Model model,String identid,HttpSession session,HttpServletRequest request) {
		//IdentStatus=2
		indservice.updentstud(identid,2);
	
		return "guanli/stuvalidate.jsp";	
	}
	
	
	
	
	
	

}