package com.project.igo.biz;

import com.project.igo.entity.Bill;
import com.project.igo.entity.Handle;

import java.util.List;

public interface HandleBiz {
    void add(Handle handle);
    List<Handle> getByBillId(int billId);
    List<Handle> getAllHandle();
}
