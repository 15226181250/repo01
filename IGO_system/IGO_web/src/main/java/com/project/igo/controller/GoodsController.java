package com.project.igo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.igo.biz.GoodsBiz;
import com.project.igo.entity.Goods;
import com.project.igo.entity.Session;
import com.project.igo.entity.User;
import com.project.igo.global.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller("goodsController")
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsBiz goodsBiz;
    //商品详情控制器
    @RequestMapping("/goods_detail")
    //这里涉及到了多个参数，故用@RequestParam来接受JSP界面传过来的参数。
    public String goods_detail(HttpSession session,@RequestParam("goodsId") String goodsId){
        if(goodsId==null){
            return "redirect:/to_start";
        }
        Goods goods = goodsBiz.get(goodsId);
        session.setAttribute("goods",goods);
        return "goods_detail";
    }
    //商品列表控制器
    @RequestMapping("/goods_list")
    public String goods_list(HttpSession session,Map<String,Object> map){
        if(session==null){
            return "redirect:/to_start";
        }
        map.put("goodslist",goodsBiz.getAll());
        return "goods_list";
    }
    //======================================================================================
    //商品去更改控制器
    @RequestMapping("/to_update_goods")
    public String toUpdateGoods(HttpSession session,@RequestParam("goodsId")String goodsId,Map<String,Object> map){
        if(session==null){
            return "redirect:/to_start";
        }
        if(goodsId==null){
            return "redirect:/to_start";
        }
        map.put("goods",goodsBiz.get(goodsId));
        //同添加一样，修改也需要获取所有身份信息
        map.put("plist", Constant.getType());
        return "goods_update";
    }
    //====================================================================================
    //商品信息修改控制器
    @RequestMapping("/update_goods")
    public String updateGoods(HttpSession session,Goods goods){
        if(session==null){
            return "redirect:/to_start";
        }
        if(goods==null){
            return "redirect:/to_start";
        }
        goodsBiz.edit(goods);
        return "redirect:/goods/goods_list";
    }
    //=========================================================================================
    //商品删除控制器
    @RequestMapping("/remove_goods")
    public String removeGoods(HttpSession session,@RequestParam("goodsId")String goodsId){
        if(session==null){
            return "redirect:/to_start";
        }
        if(goodsId==null){
            return "redirect:/to_start";
        }
        goodsBiz.remove(goodsId);
        return "redirect:goods_list";
    }
    //==================================================================================
    //商品去添加控制器
    @RequestMapping("/goods_to_add")
    public String toAddGoods(Map<String,Object> map){
        map.put("goods",new Goods());
        //从常量类中获取所有的职位信息作为一个集合传到添加界面
        map.put("plist", Constant.getType());
        return "goods_add";
    }
    //======================================================================================
    //商品添加控制器
    @RequestMapping("/goods_add")
    public String goodsAdd(Goods goods){
        if(goods==null){
            return "redirect:/to_start";
        }
        goodsBiz.add(goods);
        return "redirect:goods_list";
    }
    //商家自己的柜台商品列表
    @RequestMapping("/business_goods_list")
    public String bill_list2(HttpSession session,Map<String,Object> map){
        if(session==null){
            return "redirect:/to_start";
        }
        User user=(User)session.getAttribute("user");
        map.put("blist",goodsBiz.getByBusinessId(user.getUserId()));
        return "business_goods_list";
    }
    //用户分类查找商品
    @RequestMapping("/goods_type_list")
    public String goods_type_list(@RequestParam("goodsType")String goodsType,
    @RequestParam(value = "num", defaultValue = "1") int num, Model model){
        if(goodsType==null){
            return "redirect:/to_start";
        }
        //开始分页
        PageHelper.startPage(num,4);
        List<Goods> goodslist=goodsBiz.getByType(goodsType);
        //将商品信息放到PageInfo对象里
        PageInfo<Goods> page=new PageInfo<Goods>(goodslist,4);
        model.addAttribute("pageInfo",page);
        model.addAttribute("goodslist",goodslist);
        return "start";
    }
    //商家分类查找商品
    @RequestMapping("/goods_type_list02")
    public String goods_type_list02(@RequestParam("goodsType")String goodsType,
                                  @RequestParam(value = "num", defaultValue = "1") int num, Model model){
        if(goodsType==null){
            return "redirect:/to_start";
        }
        //开始分页
        PageHelper.startPage(num,4);
        List<Goods> goodslist=goodsBiz.getByType(goodsType);
        //将商品信息放到PageInfo对象里
        PageInfo<Goods> page=new PageInfo<Goods>(goodslist,4);
        model.addAttribute("pageInfo",page);
        model.addAttribute("goodslist",goodslist);
        return "start02";
    }
    //用户根据商品名称查找商品
    @RequestMapping("/goods_find")
    //通过@RequestParam(required = false)来接受input输入框传过来的值
    public String goodsFind(@RequestParam(required = false)String goodsName,Map<String,Object> map){
        if(goodsName==null){
            return "redirect:/to_start";
        }
        List<Goods> list=goodsBiz.getByGoodsName(goodsName);
        if(list.isEmpty()){
            return "start05";
        }
        map.put("blist",list);
        return "start03";
    }
    //商家根据商品名称查找商品
    @RequestMapping("/goods_find02")
    public String goodsFind02(@RequestParam(required = false)String goodsName,Map<String,Object> map){
        if(goodsName==null){
            return "redirect:/to_start";
        }
        List<Goods> list=goodsBiz.getByGoodsName(goodsName);
        if(list.isEmpty()){
            return "start06";
        }
        map.put("blist",list);
        return "start04";
    }
}
