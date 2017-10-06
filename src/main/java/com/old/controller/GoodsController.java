package com.old.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.old.dao.GoodspictureMapper;
import com.old.model.Childtype;
import com.old.model.Collecgoods;
import com.old.model.Deal;
import com.old.model.Fathertype;
import com.old.model.Goods;
import com.old.model.GoodsMore;
import com.old.model.Goodspicture;
import com.old.model.User;
import com.old.service.GoodsService;

@Controller
public class GoodsController {
  
	@Resource
	GoodsService goodsService;
	//获取一级分类
	@ResponseBody
	@RequestMapping("/fatherType")
	public List<Fathertype> fathertype(){
		return goodsService.fathertype();
	}
	//获取一级分类下的二级分类
	@ResponseBody
	@RequestMapping("/childType")
	public List<Childtype> childtype(String typeid) {
		return goodsService.childtype(typeid);
	}
	//发布商品
	
	@RequestMapping("/release")
	public String ReleaseGoods(@RequestParam("file1") MultipartFile cm1,@RequestParam("file2") MultipartFile cm2,
			@RequestParam("file3") MultipartFile cm3,
			@RequestParam("file4") MultipartFile cm4,
			
			Goods goods,HttpServletRequest request,HttpSession session) {
		 MultipartFile[] cms={cm1,cm2,cm3,cm4};
		 System.out.println(goods.getGoodsname());
		goodsService.ReleaseGoods(cms,goods, request, session);
		
			return "redirect:/index/firstPage.jsp";
	}
	//查询发布状态的商品信息

	@RequestMapping("/allGoods0")
	public String allGoods0(HttpSession session,Model model,int startPage,int  pageSize,HttpServletRequest request) {
		List<GoodsMore> goodsList= goodsService.allGoods("0",startPage,pageSize,request);

		int totalPages = goodsService.findGoodsNumber("0"); //
		model.addAttribute("goodsList", goodsList);
		model.addAttribute("totalPages", (totalPages/pageSize)+(totalPages%pageSize==0?0:1));
       
		return "goodsData";
	}
	@RequestMapping("/goodsDetail")
	public String goodsDetail(Model model,String goodsid,HttpServletRequest request) {
	Goods goods=goodsService.goodsDetail(goodsid,request);
		model.addAttribute("goods", goods);
		return "detail";
		
	}
	
	@RequestMapping("/userGoods0")
	public String userGoods0(HttpSession session,Model model,int startPage,int  pageSize,HttpServletRequest request) {
		User user=(User) session.getAttribute("user");
		String userid=user.getUserid();
		List<Goods> usergoodsList= goodsService.userGoods("0",userid, startPage,pageSize,request);

		int totalPages = goodsService.findGoodsNumberByUserId("0",userid); 
		model.addAttribute("usergoodsList", usergoodsList);
		model.addAttribute("totalPages", (totalPages/pageSize)+(totalPages%pageSize==0?0:1));
       
		return "userGoods";
	}
	@RequestMapping("/selectGoodsByType")
	public String selectGoodsByType(HttpSession session,Model model,int startPage,int  pageSize,HttpServletRequest request,String goodstype) {
		System.out.println(goodstype);
		List<Goods> typegoodsList= goodsService.typeGoods("0", goodstype, startPage, pageSize, request);
  
		int totalPages = goodsService.findGoodsNumberByGoodsType("0",goodstype); 
		System.out.println(totalPages);
		model.addAttribute("goodsList", typegoodsList);
		model.addAttribute("totalPages", (totalPages/pageSize)+(totalPages%pageSize==0?0:1));
      
		return "goodsData";
	}
	@RequestMapping("/searchGoods")
	public String searchGoods(HttpSession session,Model model,int startPage,int  pageSize,HttpServletRequest request,String goodsname) {
		System.out.println(goodsname);
		List<Goods> searchgoodsList= goodsService.searchGoods("0", goodsname, startPage, pageSize, request);
  
		int totalPages = goodsService.findGoodsNumberByGoodsType("0",goodsname); 
		System.out.println(totalPages);
		model.addAttribute("goodsList", searchgoodsList);
		model.addAttribute("totalPages", (totalPages/pageSize)+(totalPages%pageSize==0?0:1));
      
		return "goodsData";
	}	
}
