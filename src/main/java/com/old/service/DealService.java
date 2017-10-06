package com.old.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.old.model.Goods;

public interface DealService {
	int addShopCat(HttpSession session,String goodsid);
	int weatherAddShopCat(HttpSession session,String goodsid);
	int weatherInBuy(HttpSession session,String goodsid);
	
	List<Goods> shopcatGoods(HttpSession session,Integer startPage,Integer pageSize, HttpServletRequest request);
	int shopCatNum(HttpSession session);
	
	int addorder(HttpSession session,String goodsid);
    
	List<Goods> BuyOrder(HttpSession session,Integer startPage,Integer pageSize, HttpServletRequest request);
	int BuyOrderNum(HttpSession session,Integer startPage,Integer pageSize, HttpServletRequest request);
	
	List<Goods> SallOrder(HttpSession session,Integer startPage,Integer pageSize, HttpServletRequest request);
    int sallOrderNum(HttpSession session,Integer startPage,Integer pageSize, HttpServletRequest request);
}
