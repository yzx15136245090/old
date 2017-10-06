package com.old.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.old.model.Goods;
import com.old.model.Goodspicture;
import com.old.service.GoodsService;
import com.old.service.GoodspictureService;
@Controller
public class GoodspictureController {
	@Resource
	GoodspictureService goodspictureService;
	@Resource
	GoodsService goodsService;
	@ResponseBody
	@RequestMapping("/goodsPicture")
	public List<Goodspicture> selectPictureByGoodsId(Goods goods) {
		
		return goodspictureService.selectPictureByGoodsId(goods);
	}
}
