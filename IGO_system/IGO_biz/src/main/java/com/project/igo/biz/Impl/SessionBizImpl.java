package com.project.igo.biz.Impl;

import com.project.igo.biz.SessionBiz;
import com.project.igo.dao.SessionDao;
import com.project.igo.entity.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sessionBiz")
public class SessionBizImpl implements SessionBiz {

    @Qualifier("sessionDao")
    @Autowired
    private SessionDao sessionDao;
    public void add(Session session) {
        sessionDao.insert(session);
    }

    public void dropAll(String customId, String businessId) {
        sessionDao.deleteAll(customId,businessId);
    }

    public List<Session> getAllSession(String customId, String businessId) {
        return sessionDao.selectAllSession(customId,businessId);
    }
}
