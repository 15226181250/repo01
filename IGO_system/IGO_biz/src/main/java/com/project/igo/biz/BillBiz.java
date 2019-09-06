package com.project.igo.biz;

import com.project.igo.entity.Bill;
import com.project.igo.entity.Goods;
import com.project.igo.entity.Handle;
import com.project.igo.entity.User;

import java.util.List;

public interface BillBiz {
    //创建订单
    void add(Bill bill);
    //提交订单
    void edit(Bill bill);
    //移除订单
    void remove(int BillId);
    //通过编号得到订单
    Bill get(int BillId);


    //获取个人订单
    List<Bill> getForSelf(String customId);
    //获取待处理订单
    List<Bill> getForDeal(String customId);


    //处理订单
    void deal(Bill bill);
    //签收订单
    void accept(Bill bill);

}
