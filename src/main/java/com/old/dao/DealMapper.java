package com.old.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.old.model.Deal;


public interface DealMapper {
    int insert(Deal record);
    List<Deal> dealGoodsByUserId(@Param("dealstatus")Integer dealstatus,@Param("userid")String userid,
    		@Param("startPage")Integer startPage,@Param("pageSize")Integer pageSize);
    int insertSelective(Deal record);
    int  findshopCatNumber(String userid);
    int findGoodsByStatus(@Param("dealstatus")Integer dealstatus,@Param("userid")String userid,@Param("goodsid")String goodsid);
    
    int weatherAdd(@Param("userid")String userid,@Param("goodsid")String goodsid);
  
    int updateStatus(@Param("dealstatus")Integer dealstatus,@Param("userid")String userid,@Param("goodsid")String goodsid);
    List<Deal> sallOrde(@Param("dealstatus")Integer dealstatus,@Param("goodsid")String goodsid,@Param("startPage")Integer startPage,@Param("pageSize")Integer pageSize);
}