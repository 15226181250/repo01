package com.project.igo.biz;

import com.project.igo.entity.User;

import java.util.List;

public interface UserBiz {

    void add(User user);
    void edit(User user);
    void remove(String userId);
    User get(String userId);
    List<User> getAllUserVIP();
    List<User> getAllBusiness();
}
