package com.project.igo.dao;


import com.project.igo.entity.Goods;
import com.project.igo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

//通过注解的方式将GoodsDao放到IOC容器里，GoodsDao作为持久化操作对象
@Repository("goodsDao")
public interface GoodsDao {

    void insert(Goods goods);
    void update(Goods goods);
    void delete(String goodsId);
    Goods select(String goodsId);
    List<Goods> selectAll();
    List<Goods> selectByBusinessId(String userId);
    List<Goods> selectByType(String Type);
    List<Goods> selectByGoodsName(String goodsName);
}
