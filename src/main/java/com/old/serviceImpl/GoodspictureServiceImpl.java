package com.old.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.old.dao.GoodspictureMapper;
import com.old.model.Goods;
import com.old.model.Goodspicture;
import com.old.service.GoodspictureService;


@Service
public class GoodspictureServiceImpl implements GoodspictureService{
	
	
	@Resource
	GoodspictureMapper goodspictureMapper;

	@Override
	public List<Goodspicture> selectPictureByGoodsId(Goods goods) {
		// TODO Auto-generated method stub
		return goodspictureMapper.selectByGoodsId(goods.getGoodsid());
	}




}
