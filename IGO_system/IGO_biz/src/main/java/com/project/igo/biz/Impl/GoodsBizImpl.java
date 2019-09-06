package com.project.igo.biz.Impl;
import com.project.igo.biz.GoodsBiz;
import com.project.igo.dao.GoodsDao;
import com.project.igo.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("goodsBiz")
public class GoodsBizImpl implements GoodsBiz {

    @Qualifier("goodsDao")
    @Autowired
    private GoodsDao goodsDao;

    public void add(Goods goods) {
        goodsDao.insert(goods);
    }

    public void edit(Goods goods) {
        goodsDao.update(goods);
    }

    public void remove(String goodsId) {
        goodsDao.delete(goodsId);
    }

    public Goods get(String goodsId) {
        return goodsDao.select(goodsId);
    }

    public List<Goods> getAll() {
        return goodsDao.selectAll();
    }

    public List<Goods> getByBusinessId(String userId) {
        List<Goods> list=goodsDao.selectByBusinessId(userId);
        return list;
    }

    public List<Goods> getByType(String goodsType) {
        return goodsDao.selectByType(goodsType);
    }

    public List<Goods> getByGoodsName(String goodsName) {
        return goodsDao.selectByGoodsName(goodsName);
    }
}
