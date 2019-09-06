package com.project.igo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.igo.biz.GlobalBiz;
import com.project.igo.biz.GoodsBiz;
import com.project.igo.biz.UserBiz;
import com.project.igo.entity.Goods;
import com.project.igo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller("globalController")
public class GlobalController {

        @Autowired
        private GoodsBiz goodsBiz;
        @Autowired
        private GlobalBiz globalBiz;
        @Autowired
        private UserBiz userBiz;
    //=========================================================================================
        //访问商城控制器(用户)
        @RequestMapping("/to_start")
        public String toStart(){
            return "redirect:toIndex";
        }//(商家)
        @RequestMapping("/to_start02")
        public String toStart02(){
            return "redirect:toIndex02";
        }

    //=================================================================================
        @RequestMapping(value = "/toIndex" ,method = RequestMethod.GET)
        public String toIndex(@RequestParam(value = "num", defaultValue = "1") int num,
                              Model model){
            //开始分页
            PageHelper.startPage(num,4);
            List<Goods> goodslist=goodsBiz.getAll();
            //将商品信息放到PageInfo对象里
            PageInfo<Goods> page=new PageInfo<Goods>(goodslist,4);
            model.addAttribute("pageInfo",page);
            model.addAttribute("goodslist",goodslist);
            return "start";
        }
        @RequestMapping(value = "/toIndex02" ,method = RequestMethod.GET)
        public String toIndex02(@RequestParam(value = "num", defaultValue = "1") int num,
                              Model model){
            //开始分页
            PageHelper.startPage(num,4);
            List<Goods> goodslist=goodsBiz.getAll();
            //将商品信息放到PageInfo对象里
            PageInfo<Goods> page=new PageInfo<Goods>(goodslist,4);
            model.addAttribute("pageInfo",page);
            model.addAttribute("goodslist",goodslist);
            return "start02";
        }
        //===========================================================================================
        //打开登陆界面,可以不干任何事情
        @RequestMapping("/to_login")
        //如果toLogin这个登陆页面想使用springMVC提供的form标签,则要求必须传一个对象,也可以用map添加值
        //这里我们只是简单的输一下密码和账户，不使用springMVC提供的form标签
        public String toLogin(){

                //返回登陆界面
                return "login";

        }
        //===============================================================================================
        @RequestMapping("/login")
        //这里涉及到了多个参数，故用@RequestParam来标明这两个参数都是用来接收用户提交过来的信息的
        public String login(HttpSession session, @RequestParam(required = true) String uid, @RequestParam(required = true) String password){
            if(session==null){
                return "redirect:/to_start";
            }
            if(uid==null){
                return "redirect:/to_start";
            }
            if(password==null){
                return "redirect:/to_start";
            }
            //通过业务层的方法来验证密码是否正确，是否可以登陆
            User user = globalBiz.login(uid,password);
            if (user == null) {
                //如果登陆失败则重定向到去登陆控制器
                return "redirect:to_login";
            }
            //直接在参数列表中声明一个Session，spring就会自动的把Session注入进来，直接拿来用即可
            //如果登陆成功则将用户信息放到Session作用域中，即会话中
            session.setAttribute("user",user);
            if(user.getUserId().equals("8001")){
                return "admin_system";
            }else if(user.getIdentity().equals("商家")){
                return "redirect:to_start02";
            }
            //登陆成功后直接跳转到商品首页
            return "redirect:to_start";
        }
        //========================================================================================
        //个人信息控制器
        @RequestMapping("/self")
        public String self(HttpSession session){
            if(session==null){
                return "redirect:/to_start";
            }
            User user=(User)session.getAttribute("user");
            if(user==null){
                return "redirect:/to_login";
            }
            //返回个人信息界面
            return  "self";
        }
        //======================================================================================
        //退出控制器
        @RequestMapping("/quit")
        public String quit(HttpSession session){
            if(session==null){
                return "redirect:/to_start";
            }
            User user=(User)session.getAttribute("user");
            if(user==null){
                return "redirect:/to_login";
            }
            //退出和登陆相似，直接将Session中的信息置为空即可
            session.setAttribute("user",null);
            //退出成功后，通过重定向，再跳转到商城界面
            return "redirect:to_start";
        }
        //=========================================================================================
        @RequestMapping("/to_change_password")
        public String toChangePassword(){
            //跳到修改密码界面
            return "change_password";
        }
        //==========================================================================================
        //修改密码控制器
        @RequestMapping("/change_password")
        //除了需要创建Session对象，还需要将旧密码，两次新密码传到控制器里面
        public String changePassword(HttpSession session, @RequestParam String old, @RequestParam String new1 , @RequestParam String new2){
            if(session==null){
                return "redirect:/to_start";
            }
            //从Session作用域中取出对象
            User user = (User) session.getAttribute("user");
            if(user.getPassword().equals(old)){
                if(new1.equals(new2)){
                    user.setPassword(new1);
                    globalBiz.changePassword(user);
                    //如果旧密码输入正确，且两次新密码输入正确，则修改成功，重定向跳转到个人信息控制器
                    return "redirect:self";
                }
            }
            //如果不成功则重定向跳转到去修改的控制器
            return "redirect:to_change_password";
        }


}
