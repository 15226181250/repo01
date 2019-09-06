package com.project.igo.dao;


import com.project.igo.entity.Bill;
import org.springframework.stereotype.Repository;

import java.util.List;

//通过注解的方式将BillDao放到IOC容器里，BillDao作为持久化操作对象
@Repository("billDao")
public interface BillDao {

    void insert(Bill bill);
    void update(Bill bill);
    void delete(int bid);
    Bill select(int bid);
    //通过顾客编号，查询该顾客创建的所有订单
    List<Bill> selectByCustomId(String customId);
    //通过商家编号，查询该商家应该处理的所有订单
    List<Bill> selectByBusinessId(String customId);

}
