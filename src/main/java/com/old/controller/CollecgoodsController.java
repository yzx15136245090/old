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
import com.old.service.CollecgoodsService;
import com.old.service.GoodsService;

@Controller
public class CollecgoodsController {
	@Resource
	GoodsService goodsService;
	@Resource
	CollecgoodsService collecgoodsService;
	
	@ResponseBody
	@RequestMapping("/collectGoods")
	public String addcollectGoods(String goodsid,HttpSession session){
		if(collecgoodsService.weatherCollect(goodsid, session)==0){
		collecgoodsService.collectGoods(goodsid, session);
		return "0";
		}
		else {
			return "1";
		}
		
		
	}

	@RequestMapping("/myCollectGoods")
	public String CollectGoods(HttpSession session,Model model,int startPage,int  pageSize,HttpServletRequest request) {
		List<Goods> collecgoodsList= collecgoodsService.myCollectGoods(session, startPage, pageSize,request);

		int totalPages = collecgoodsService.findCollec(session);
		model.addAttribute("collecgoodsList", collecgoodsList);
		model.addAttribute("totalPages", (totalPages/pageSize)+(totalPages%pageSize==0?0:1));
       
		return "myCollect";
	}
	
}
