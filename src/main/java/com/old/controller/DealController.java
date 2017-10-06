package com.old.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.old.model.Goods;
import com.old.service.DealService;
import com.old.service.GoodsService;

@Controller
public class DealController {
	@Resource
	GoodsService goodsService;
	@Resource
	DealService dealService;
	
	@ResponseBody
	@RequestMapping("/addbuy")
	public String addbuy(HttpSession session,String goodsid){
		//if(dealService.weatherInBuy(session, goodsid)==0){
			dealService.addorder(session, goodsid);
			return "0";
		// }
		//else{
		//	return "1";
		//}
		
	}
	
	@ResponseBody
	@RequestMapping("/addshopcat")
	public String addshopcat(HttpSession session,String goodsid){
		if(dealService.weatherAddShopCat(session, goodsid)==0){
			dealService.addShopCat(session, goodsid);
			return "0";
		 }
		else{
			return "1";
		}
		
	}
	@RequestMapping("/shopcatGoods")
	public String shopcatGoods(HttpSession session,Model model,int startPage,int  pageSize,HttpServletRequest request){
	List<Goods> shopcats=dealService.shopcatGoods(session, startPage, pageSize,request);
	int totalPages = dealService.shopCatNum(session);
	model.addAttribute("shopcats", shopcats);
	model.addAttribute("totalPages", (totalPages/pageSize)+(totalPages%pageSize==0?0:1));
		return "userShopCat";
	}
	@RequestMapping("/myBuyOrder")
	public String buyorder(HttpSession session,Model model,int startPage,int  pageSize,HttpServletRequest request){
	List<Goods> myBuyOrderList=dealService.BuyOrder(session, startPage, pageSize, request);
	int totalPages = dealService.BuyOrderNum(session, startPage, pageSize, request);
	model.addAttribute("myBuyOrderList", myBuyOrderList);
	model.addAttribute("totalPages", (totalPages/pageSize)+(totalPages%pageSize==0?0:1));
		return "myBuyOrder";
	}
	@RequestMapping("/mySallOrder")
	public String sallorder(HttpSession session,Model model,int startPage,int  pageSize,HttpServletRequest request){
	List<Goods> mySallOrderList=dealService.SallOrder(session, startPage, pageSize, request);
	int totalPages = dealService.sallOrderNum(session, startPage, pageSize, request);
	model.addAttribute("mySallOrderList", mySallOrderList);
	model.addAttribute("totalPages", (totalPages/pageSize)+(totalPages%pageSize==0?0:1));
		return "mySallOrder";
	}
	
}
