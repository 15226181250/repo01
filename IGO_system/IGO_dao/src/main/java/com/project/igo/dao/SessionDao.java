package com.project.igo.dao;

import com.project.igo.entity.Session;
import com.project.igo.entity.User;

import java.util.List;

public interface SessionDao {
    void insert(Session session);
    void deleteAll(String customId,String businessId);
    List<Session> selectAllSession(String customId, String businessId);
}
