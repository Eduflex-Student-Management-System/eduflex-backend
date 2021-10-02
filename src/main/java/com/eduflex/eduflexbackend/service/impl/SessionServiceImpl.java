package com.eduflex.eduflexbackend.service.impl;

import com.eduflex.eduflexbackend.model.Session;
import com.eduflex.eduflexbackend.repository.SessionRepository;
import com.eduflex.eduflexbackend.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    SessionRepository sessionRepository;

    @Override
    public Session addSession(Session session) {
        return sessionRepository.save(session);
    }

    @Override
    public Session updateSession(Session session) {
        return sessionRepository.save(session);
    }

    @Override
    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    @Override
    public void deleteSession(int sessionId) {
        sessionRepository.deleteById(sessionId);
    }

    @Override
    public Session getSessionById(int sessionId) {
        return sessionRepository.findById(sessionId).get();
    }

}
