package com.project.igo.biz.Impl;

import com.project.igo.biz.BillBiz;
import com.project.igo.biz.HandleBiz;
import com.project.igo.dao.*;
import com.project.igo.entity.Bill;
import com.project.igo.entity.Handle;
import com.project.igo.global.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("billBiz")
public class BillBizImpl implements BillBiz {
    @Qualifier("userDao")
    @Autowired
    private UserDao userDao;
    @Qualifier("goodsDao")
    @Autowired
    private GoodsDao goodsDao;
    @Qualifier("billDao")
    @Autowired
    private BillDao billDao;
    @Qualifier("handleDao")
    @Autowired
    private HandleDao handleDao;
    @Qualifier("handleBiz")
    @Autowired
    private HandleBiz handleBiz;
    //添加订单
    public void add(Bill bill) {
        //设置时间
        bill.setCreateTime(new Date());
        //从常量类里面获取报销单状态
        bill.setStatus(Constant.NEWCREATE);

        billDao.insert(bill);
        billDao.select(bill.getBid());
        //创建handle去记录过程
        Handle handle=new Handle();
        handle.setBillId(bill.getBid());
        handle.setBusinessId(bill.getBusinessId());
        handle.setCustomId(bill.getCustomId());
        handle.setHandleTime(bill.getCreateTime());
        handle.setPost(bill.getStatus());
        handleBiz.add(handle);
    }
    //修改订单
    public void edit(Bill bill) {
        bill.setStatus(Constant.WAITSENT);
        bill.setCreateTime(new Date());
        billDao.update(bill);
        billDao.select(bill.getBid());
        //创建handle去记录过程
        Handle handle=new Handle();
        handle.setBillId(bill.getBid());
        handle.setBusinessId(bill.getBusinessId());
        handle.setCustomId(bill.getCustomId());
        handle.setHandleTime(bill.getCreateTime());
        handle.setPost(bill.getStatus());
        handleBiz.add(handle);
    }
    //移除订单
    public void remove(int BillId) {
        billDao.delete(BillId);
    }
    //通过订单号查询订单
    public Bill get(int billId) {
        Bill bill=billDao.select(billId);
        return bill;
    }

    //用户的所有订单
    public List<Bill> getForSelf(String customId) {
        List<Bill> list=billDao.selectByCustomId(customId);

        return list;
    }

    //商家应处理的所有订单
    public List<Bill> getForDeal(String customId) {
        List<Bill> list=billDao.selectByBusinessId(customId);
        return list;
    }


    //处理订单
    public void deal(Bill bill) {
        bill.setStatus(Constant.ALREADYSENT);
        bill.setCreateTime(new Date());
        billDao.update(bill);
        billDao.select(bill.getBid());
        //创建handle去记录过程
        Handle handle=new Handle();
        handle.setBillId(bill.getBid());
        handle.setBusinessId(bill.getBusinessId());
        handle.setCustomId(bill.getCustomId());
        handle.setHandleTime(bill.getCreateTime());
        handle.setPost(bill.getStatus());
        handleBiz.add(handle);
    }

    public void accept(Bill bill) {
        bill.setStatus(Constant.ALREADYACCEPT);
        bill.setCreateTime(new Date());
        billDao.update(bill);
        billDao.select(bill.getBid());
        //创建handle去记录过程
        Handle handle=new Handle();
        handle.setBillId(bill.getBid());
        handle.setBusinessId(bill.getBusinessId());
        handle.setCustomId(bill.getCustomId());
        handle.setHandleTime(bill.getCreateTime());
        handle.setPost(bill.getStatus());
        handleBiz.add(handle);
    }
}
