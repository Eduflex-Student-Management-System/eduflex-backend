package com.eduflex.eduflexbackend.service;

import com.eduflex.eduflexbackend.model.Session;

import java.util.List;

public interface SessionService {
    Session addSession(Session session);

    Session updateSession(Session session);

    List<Session> getAllSessions();

    void deleteSession(int sessionId);

    Session getSessionById(int sessionId);
}
