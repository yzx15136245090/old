package com.old.dao;

import java.util.List;

import com.old.model.Childtype;
import com.old.model.Fathertype;

public interface ChildtypeMapper {
    int deleteByPrimaryKey(String childtypeid);

    int insert(Childtype record);

    int insertSelective(Childtype record);

    Childtype selectByPrimaryKey(String childtypeid);

    int updateByPrimaryKeySelective(Childtype record);

    int updateByPrimaryKey(Childtype record);
    List<Childtype> selectchildtype(String typeid);
    Childtype childSearchGoods(String childtypename);
}