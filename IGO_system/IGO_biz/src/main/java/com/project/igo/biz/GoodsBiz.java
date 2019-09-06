package com.project.igo.biz;

import com.project.igo.entity.Goods;

import java.util.List;

public interface GoodsBiz {
    void add(Goods goods);
    void edit(Goods goods);
    void remove(String goodsId);
    Goods get(String goodsId);
    List<Goods> getAll();
    List<Goods> getByBusinessId(String userId);
    List<Goods> getByType(String goodsType);
    List<Goods> getByGoodsName(String goodsName);
}
