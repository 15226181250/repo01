package com.project.igo.dao;


import com.project.igo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

//通过注解的方式将UserDao放到IOC容器里，UserDao作为持久化操作对象
@Repository("userDao")
public interface UserDao {

    void insert(User user);
    void update(User user);
    void delete(String userId);
    User select(String userId);
    List<User> selectAllUserVIP();
    List<User> selectAllBusiness();
}
