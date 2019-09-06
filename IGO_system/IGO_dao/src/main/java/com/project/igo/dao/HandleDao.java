package com.project.igo.dao;


import com.project.igo.entity.Handle;
import org.springframework.stereotype.Repository;

import java.util.List;

//通过注解的方式将HandleDao放到IOC容器里，HandleDao作为持久化操作对象
@Repository("handleDao")
public interface HandleDao {

    //因为处理记录肯定不可以修改和删除，所以不添加这些功能
    void insert(Handle handle);
    //通过订单编号查询订单所有处理流程
    List<Handle> selectByBillId(int billId);
    //查询所有订单处理流程
    List<Handle> selectAll();
}
