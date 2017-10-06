package com.old.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.old.model.Goods;

public interface CollecgoodsService {
	void collectGoods(String goodsid,HttpSession session);
	List<Goods> myCollectGoods(HttpSession session,Integer startPage,Integer pageSize, HttpServletRequest request);
	int findCollec(HttpSession session);
	int weatherCollect(String goodsid,HttpSession session);
}
