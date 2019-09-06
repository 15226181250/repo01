package com.project.igo.biz;

import com.project.igo.entity.User;

public interface GlobalBiz {

    //用户登陆方法
    User login(String userId, String password);
    //用户修改密码方法
    void changePassword(User user);
    //由于查询用户信息和退出用户都是对Sission经行操作，故将其放到表现层进行处理
}
