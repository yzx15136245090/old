package com.old.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.old.model.Childtype;
import com.old.model.Collecgoods;
import com.old.model.Deal;
import com.old.model.Fathertype;
import com.old.model.Goods;
import com.old.model.GoodsMore;
import com.old.model.Goodspicture;

public interface GoodsService {
	//发布商品
void ReleaseGoods(MultipartFile[] cms,Goods goods,HttpServletRequest request,HttpSession session);
//获取父类名称
List<Fathertype> fathertype();
//获取子类名称
List<Childtype> childtype(String typeid);

//发布或下架状态商品
List<GoodsMore> allGoods(String status,Integer startPage,
		Integer pageSize,HttpServletRequest request);
int findGoodsNumber(String status);
//登录用户发布的商品，我的发布
List<Goods> userGoods(String status,String userid,
Integer startPage,Integer pageSize,HttpServletRequest request);
int findGoodsNumberByUserId(String status,String userid);
//按照类别搜索的某一类商品
List<Goods> typeGoods(String status, String goodstype,
Integer startPage, Integer pageSize,HttpServletRequest request);
int findGoodsNumberByGoodsType(String status,String goodstype);
//商品详情
Goods goodsDetail(String goodsid,HttpServletRequest request);
//模糊搜索商品
List<Goods> searchGoods(String status, String goodsname,
Integer startPage, Integer pageSize,HttpServletRequest request);
int findGoodsNumberBySearch(String status, String goodsname);



}
