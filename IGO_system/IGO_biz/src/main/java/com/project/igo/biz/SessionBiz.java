package com.project.igo.biz;

import com.project.igo.entity.Session;

import java.util.List;

public interface SessionBiz {
    void add(Session session);
    void dropAll(String customId,String businessId);
    List<Session> getAllSession(String customId, String businessId);
}
