package com.old.service;

import java.util.List;

import com.old.model.Goods;
import com.old.model.Goodspicture;

public interface GoodspictureService {
	List<Goodspicture> selectPictureByGoodsId(Goods goods);
}
