package com.eduflex.eduflexbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eduflex.eduflexbackend.model.Session;
import com.eduflex.eduflexbackend.service.SessionService;

@RestController
@CrossOrigin
public class SessionController {

	@Autowired
	SessionService sessionService;

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
