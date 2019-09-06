package com.project.igo.controller;

import com.project.igo.biz.BillBiz;
import com.project.igo.biz.GoodsBiz;
import com.project.igo.biz.HandleBiz;
import com.project.igo.biz.SessionBiz;
import com.project.igo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller("billController")
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private BillBiz billBiz;
    @Autowired
    private GoodsBiz goodsBiz;
    @Autowired
    private HandleBiz handleBiz;
    @Autowired
    private SessionBiz sessionBiz;

    //用户去创建订单单
    @RequestMapping("/to_add")
    //通过@RequestParam("goodsId")来接受页面传过来的参数
    public String toAdd(HttpSession session,@RequestParam("goodsId") String goodsId){
        if(session==null){
            return "redirect:/to_start";
        }
        if(goodsId==null){
            return "redirect:/to_start";
        }
        Goods goods=goodsBiz.get(goodsId);
        User user=(User)session.getAttribute("user");
        if(user==null){
            return "redirect:/to_login";
        }
        Bill bill=new Bill();
        bill.setGoodsId(goods.getGoodsId());
        bill.setTotalPrice(goods.getGoodsPrice());
        bill.setCustomId(user.getUserId());
        bill.setBusinessId(goods.getBusinessId());
        billBiz.add(bill);
        session.setAttribute("bill" ,bill);

        return "redirect:to_bill_list";
    }
    //去查看用户购物车订单列表
    @RequestMapping("/to_bill_list")
    public String to_bill_list(HttpSession session){
        if(session==null){
            return "redirect:/to_start";
        }
        User user=(User)session.getAttribute("user");
        if(user==null){
            return "redirect:/to_login";
        }else if(user.getIdentity().equals("普通用户") || user.getIdentity().equals("至尊会员") || user.getIdentity().equals("商家")){
            return "redirect:bill_list1";
        }
        return "redirect:/to_login";
    }
    //去查看商家待处理订单列表
    @RequestMapping("/to_bill_list02")
    public String to_bill_list02(HttpSession session){
        if(session==null){
            return "redirect:/to_start";
        }
        User user=(User)session.getAttribute("user");
        if(user==null){
            return "redirect:/to_login";
        }else if(user.getIdentity().equals("商家")) {
            return "redirect:bill_list2";

        }return "redirect:/to_login";
    }
    //用户购物车订单列表
    @RequestMapping("/bill_list1")
    public String bill_list1(HttpSession session,Map<String,Object> map){
        if(session==null){
            return "redirect:/to_start";
        }
        User user=(User)session.getAttribute("user");
        map.put("blist",billBiz.getForSelf(user.getUserId()));
        return "bill_list";
    }
    //商家待处理订单列表
    @RequestMapping("/bill_list2")
    public String bill_list2(HttpSession session,Map<String,Object> map){
        if(session==null){
            return "redirect:/to_start";
        }
        User user=(User)session.getAttribute("user");
        map.put("blist",billBiz.getForDeal(user.getUserId()));
        return "bill_list02";
    }
    //用户购物车订单详情
    @RequestMapping("/bill_detail")
    public String bill_detail(HttpSession session,@RequestParam("bibi")int bibi){
        if(session==null){
            return "redirect:/to_start";
        }
        if(bibi==0){
            return "redirect:/to_start";
        }
        Bill bill=billBiz.get(bibi);
        session.setAttribute("billd",bill);
        return "bill_detail";
    }
    //商家待处理订单详情
    @RequestMapping("/bill_detail02")
    public String bill_detail02(HttpSession session,@RequestParam("bibi")int bibi){
        if(session==null){
            return "redirect:/to_start";
        }
        if(bibi==0){
            return "redirect:/to_start";
        }
        Bill bill=billBiz.get(bibi);
        session.setAttribute("billd",bill);
        return "bill_detail02";
    }
    //删除订单
    @RequestMapping("/bill_delete")
    public String bill_delete(HttpSession session,@RequestParam("bibi")int bibi){
        if(session==null){
            return "redirect:/to_start";
        }
        if(bibi==0){
            return "redirect:/to_start";
        }
        billBiz.remove(bibi);
        return "redirect:bill_list1";
    }
    //用户提交订单
    @RequestMapping("/bill_submit")
    public String bill_submit(HttpSession session,@RequestParam("bibi")int bibi){
        if(session==null){
            return "redirect:/to_start";
        }
        if(bibi==0){
            return "redirect:/to_start";
        }
        Bill bill=billBiz.get(bibi);
        if(bill.getStatus().equals("新创建")){

            //用户结算订单
            billBiz.edit(bill);

            return "redirect:bill_list1";
        }
        return "bill_detail";
    }
    //商家处理订单发货
    @RequestMapping("/bill_sent_goods")
    public String bill_sent_goods(HttpSession session,@RequestParam("bibi")int bibi){
        if(session==null){
            return "redirect:/to_start";
        }
        if(bibi==0){
            return "redirect:/to_start";
        }
        Bill bill=billBiz.get(bibi);
        if(bill.getStatus().equals("待发货")){

            //商家去发货
            billBiz.deal(bill);

            return "redirect:bill_list2";
        }
        return "bill_detail02";
    }
    //用户签收订单
    @RequestMapping("/bill_accept")
    public String bill_accept(HttpSession session,@RequestParam("bibi")int bibi){
        if(session==null){
            return "redirect:/to_start";
        }
        if(bibi==0){
            return "redirect:/to_start";
        }
        Bill bill=billBiz.get(bibi);
        if(bill.getStatus().equals("已发货")){

            billBiz.accept(bill);
            return "redirect:bill_list1";
        }
        return "bill_detail";
    }
    //交易过程列表控制器
    @RequestMapping("/handle_list")
    public String handle_list(Map<String,Object> map){
        List<Handle> list=handleBiz.getAllHandle();
        //将每个订单的多条信息先过滤成一条以确保一个订单只显示一次
        List<Handle> list01=new ArrayList<Handle>();
        for(Handle handle:list){
            if(handle.getPost().equals("新创建")){
                list01.add(handle);
            }
        }
        map.put("handlelist",list01);

        return "handle_list";
    }
    //详细交易过程
    @RequestMapping("/handle_detail")
    //这里涉及到了多个参数，故用@RequestParam来接受JSP界面传过来的参数。
    public String handle_detail(Map<String,Object> map,@RequestParam("billId") int billId){
        if(billId==0){
            return "redirect:/to_start";
        }
        List<Handle> list=handleBiz.getByBillId(billId);
        map.put("hlist",list);
        return "handle_detail";
    }
    //联系客服
    @RequestMapping("/to_session")
    //这里涉及到了多个参数，故用@RequestParam来接受JSP界面传过来的参数。
    public String to_session(Map<String,Object> map,
                             @RequestParam("businessId") String businessId){
        if(businessId==null){
            return "redirect:/to_start";
        }
        map.put("session",new Session());
        return "to_session";
    }
    //
    @RequestMapping("/session")
    public String session(Session session,HttpSession httpSession,
                          @RequestParam("businessId") String businessId){
        if(session==null){
            return "redirect:/to_start";
        }
        if(businessId==null){
            return "redirect:/to_start";
        }
        User user= (User) httpSession.getAttribute("user");
        if(user==null){
            return "redirect:/to_login";
        }
        session.setBusinessId(businessId);
        session.setCustomId(user.getUserId());
        session.setCreateTime(new Date());
        sessionBiz.add(session);
        sessionBiz.add(session);
        return "start";
    }
}


