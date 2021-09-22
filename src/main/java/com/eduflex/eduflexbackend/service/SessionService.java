package com.eduflex.eduflexbackend.service;

import java.util.List;

import com.eduflex.eduflexbackend.model.Session;

public interface SessionService {
	Session addSession(Session session);
	Session updateSession(Session session);
	List<Session> getAllSessions();
	void deleteSession(int sessionId);
	Session getSessionById(int sessionId);
}
