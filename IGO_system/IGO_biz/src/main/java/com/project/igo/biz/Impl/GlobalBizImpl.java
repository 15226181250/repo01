package com.project.igo.biz.Impl;

import com.project.igo.biz.GlobalBiz;
import com.project.igo.dao.UserDao;
import com.project.igo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("globalBiz")
public class GlobalBizImpl implements GlobalBiz {

    @Qualifier("userDao")
    @Autowired
    private UserDao userDao;

    public User login(String userId, String password) {
        //通过userDao的select方法来得到所要查询的user
        User user = userDao.select(userId);
        //如果密码匹配成功则返回一个用户
        if(user!=null&&user.getPassword().equals(password)){
            return  user;
        }
        return null;
    }


    //修改密码，直接通过userDao的update将用户的信息进行修改
    public void changePassword(User user) {
        userDao.update(user);
    }

}
