package com.old.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.old.model.Goods;
import com.old.model.GoodsMore;

public interface GoodsMoreMapper {
	List<GoodsMore> findGoodsMoreByLImit(@Param("status")String status,@Param("startPage")Integer startPage,@Param("pageSize")Integer pageSize);
	Goods selectByPrimaryKey(String goodsid);
	List<GoodsMore> findGoodsMoreByType(@Param("status")String status,@Param("startPage")Integer startPage,@Param("pageSize")Integer pageSize,@Param("goodstype")String goodsType);
}
