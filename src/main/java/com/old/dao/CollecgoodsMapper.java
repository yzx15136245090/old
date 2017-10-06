package com.old.dao;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.old.model.Collecgoods;

public interface CollecgoodsMapper {
    int insert(Collecgoods record);
    List<Collecgoods> myCollect(@Param("userid")String userid,@Param("startPage")Integer startPage,@Param("pageSize")Integer pageSize);
    int findCollecNumber(String userid);
    int insertSelective(Collecgoods record);
    int weatherCollect(@Param("userid")String userid,@Param("goodsid")String goodsid);
}