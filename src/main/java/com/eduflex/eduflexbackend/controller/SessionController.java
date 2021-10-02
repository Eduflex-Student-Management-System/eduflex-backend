package com.eduflex.eduflexbackend.controller;

import com.eduflex.eduflexbackend.model.Session;
import com.eduflex.eduflexbackend.repository.SessionRepository;
import com.eduflex.eduflexbackend.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SessionController {

    @Autowired
    SessionService sessionService;

    @Autowired
    SessionRepository sessionRepository;

    @PostMapping("/session")
    public Session addSession(@RequestBody Session session) {
        return sessionService.addSession(session);
    }

    @PutMapping("/session")
    public Session updateSession(@RequestBody Session session) {
        return sessionService.updateSession(session);
    }

    @GetMapping("/sessions")
    public List<Session> getAllSessions() {
        return sessionService.getAllSessions();
    }

    @DeleteMapping("/session/{sessionId}")
    public void deleteSession(@PathVariable int sessionId) {
        sessionService.deleteSession(sessionId);
    }

    @GetMapping("/session/{sessionId}")
    public Session getSessionById(@PathVariable int sessionId) {
        return sessionService.getSessionById(sessionId);
    }

}
