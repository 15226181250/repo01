package com.project.igo.global;

import java.util.ArrayList;
import java.util.List;

public class Constant {

    //身份
    public static final String USER="普通用户";
    public static final String VIP="至尊会员";
    public static final String CONTROLLER="管理员";
    public static final String BUSINESS="商家";
    //用户在选择创建新用户时只能选择成为普通用户或者至尊会员
    public static List<String> getIdentity(){
        List<String> list=new ArrayList<String>();
        list.add(USER);
        return list;
    }
    public static List<String> getAllIdentity(){
        List<String> list=new ArrayList<String>();
        list.add(USER);
        list.add(VIP);
        list.add(BUSINESS);
        return list;
    }

    //商品类型
    public static List<String> getType(){
        List list=new ArrayList();
        list.add("食品");
        list.add("玩具");
        list.add("家电");
        list.add("服装");
        list.add("家具");
        list.add("生活用品");
        list.add("智能产品");
        return list;
    }

    //订单状态
    public static final String NEWCREATE="新创建";
    public static final String WAITSENT="待发货";
    public static final String ALREADYSENT="已发货";
    public static final String ALREADYACCEPT="已收货";

    //订单处理方式
    public static final String CREATE="创建";
    public static final String SUBMIT="提交";
    public static final String UPDATE="修改";
    public static final String SENTGOODS="发货";
    public static final String ACCEPTGOODS="收货";

}
