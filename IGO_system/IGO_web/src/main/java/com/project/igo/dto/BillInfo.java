package com.project.igo.dto;

import com.project.igo.entity.Bill;
import com.project.igo.entity.Goods;

public class BillInfo {
    //创建一个账单对象
    private Bill bill;
    private Goods goods;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
