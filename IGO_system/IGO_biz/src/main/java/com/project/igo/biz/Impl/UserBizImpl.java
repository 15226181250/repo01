package com.project.igo.biz.Impl;

import com.project.igo.biz.UserBiz;
import com.project.igo.dao.UserDao;
import com.project.igo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userBiz")
public class UserBizImpl implements UserBiz {

    @Qualifier("userDao")
    @Autowired
    private UserDao userDao;

    public void add(User user) {
        //这是业务规则，为用户设置一个初始密码
        //user.setPassword("000000");
        userDao.insert(user);
    }

    public void edit(User user) {
        userDao.update(user);
    }

    public void remove(String userId) {
        userDao.delete(userId);
    }

    public User get(String userId) {
        return userDao.select(userId);
    }

    public List<User> getAllUserVIP() {
        return userDao.selectAllUserVIP();
    }

    public List<User> getAllBusiness() {
        return userDao.selectAllBusiness();
    }
}
