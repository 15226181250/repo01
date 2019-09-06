package com.project.igo.biz.Impl;

import com.project.igo.biz.HandleBiz;
import com.project.igo.dao.HandleDao;
import com.project.igo.entity.Handle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("handleBiz")
public class HandleBizImpl implements HandleBiz {

    @Qualifier("handleDao")
    @Autowired
    private HandleDao handleDao;
    public void add(Handle handle) {
        handleDao.insert(handle);

    }

    public List<Handle> getByBillId(int billId) {
        List<Handle> list=handleDao.selectByBillId(billId);
        return list;
    }

    public List<Handle> getAllHandle() {
        List<Handle> list=handleDao.selectAll();
        return list;
    }
}
