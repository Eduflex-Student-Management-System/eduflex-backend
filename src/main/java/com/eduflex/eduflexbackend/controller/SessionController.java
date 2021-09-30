package com.eduflex.eduflexbackend.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eduflex.eduflexbackend.exception.EduflexDataNotFoundException;
import com.eduflex.eduflexbackend.model.Session;
import com.eduflex.eduflexbackend.repository.SessionRepository;
import com.eduflex.eduflexbackend.service.SessionService;

@RestController
@CrossOrigin
public class SessionController {

	@Autowired
	SessionService sessionService;
	
	@Autowired
	SessionRepository sessionRepository;

	@PostMapping("/session")
	public Session addSession(@RequestBody Session session) {
		if(!sessionRepository.equals(session)) {
    		throw new EduflexDataNotFoundException("Session Date is required");
    	}
		return sessionService.addSession(session);
	}

	@PutMapping("/session")
	public Session updateSession(@RequestBody Session session) {
		return sessionService.updateSession(session);
	}

	@GetMapping("/sessions")
	public List<Session> getAllSessions() {
		if(sessionRepository.findAll().size() == 0) {
			throw new EduflexDataNotFoundException("Session Not Found, Add session first");
		}
		return sessionService.getAllSessions();
	}

	@DeleteMapping("/session/{sessionId}")
	public void deleteSession(@PathVariable int sessionId) {
		if(!sessionRepository.existsById(sessionId)) {
    		throw new EduflexDataNotFoundException("Can't delete session, sessionId: "+sessionId+" not persent in database");
    	}
		sessionService.deleteSession(sessionId);
	}

	@GetMapping("/session/{sessionId}")
	public Session getSessionById(@PathVariable int sessionId) {
		if(!sessionRepository.existsById(sessionId)) {
    		throw new EduflexDataNotFoundException("Can't find session with sessionId: "+sessionId+", please insert first");
    	}
		return sessionService.getSessionById(sessionId);
	}

}
