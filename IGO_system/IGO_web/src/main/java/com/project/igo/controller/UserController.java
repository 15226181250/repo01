package com.project.igo.controller;

import com.project.igo.biz.UserBiz;
import com.project.igo.entity.User;
import com.project.igo.global.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@Controller("userController")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserBiz userBiz;
    //=================================================================================
    @RequestMapping("/user_list")
    //用户列表控制器
   public String user_list(HttpSession session,Map<String, Object> map){
        if(session==null){
            return "redirect:/to_start";
        }
        map.put("userlist",userBiz.getAllUserVIP());
        return "user_list";
    }
    //商家列表控制器
    @RequestMapping("/business_list")
    public String business_list(HttpSession session,Map<String,Object> map){
        if(session==null){
            return "redirect:/to_start";
        }
        map.put("businesslist",userBiz.getAllBusiness());
        return "business_list";
    }
    //==================================================================================
    //用户去添加控制器
    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
        map.put("user",new User());
        //从常量类中获取所有的职位信息作为一个集合传到添加界面
        map.put("plist", Constant.getIdentity());
        return "user_add";
    }
    //======================================================================================
    //用户添加控制器
    @RequestMapping("/add")
    public String add(User user,@RequestParam(required = false)String userId){
        List<User> list=userBiz.getAllUserVIP();
        for (User u:list){
            if(u.getUserId().equals("8004")){
                return "redirect:to_add";
            }
        }
    userBiz.add(user);
        return "redirect:/to_login";
    }
    //======================================================================================
    @RequestMapping("/to_update_user")
    public String toUpdateUser(@RequestParam("userId")String userId, Map<String,Object> map){
        if(userId==null){
            return "redirect:/to_start";
        }
        map.put("user",userBiz.get(userId));
        //同添加一样，修改也需要获取所有身份信息
        map.put("plist", Constant.getAllIdentity());
        return "user_update";
    }
    //====================================================================================
    //用户信息修改控制器
    @RequestMapping("/update_user")
    public String updateUser(HttpSession session,User user){
        if(session==null){
            return "redirect:/to_start";
        }
        if(user==null){
            return "redirect:/to_start";
        }
        userBiz.edit(user);
        return "admin_system";
    }
    //=========================================================================================
    //用户删除控制器
    @RequestMapping("/remove_user")
    public String removeUser(HttpSession session,@RequestParam("userId")String userId){
        if(session==null){
            return "redirect:/to_start";
        }
        if(userId==null){
            return "redirect:/to_start";
        }
        userBiz.remove(userId);
        return "admin_system";
    }

}