package com.eduflex.eduflexbackend;

import com.eduflex.eduflexbackend.model.Session;
import com.eduflex.eduflexbackend.repository.SessionRepository;
import com.eduflex.eduflexbackend.service.SessionService;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class SessionCRUDTest {
	
	@Autowired
	SessionRepository sessionRepository;
	
	@Autowired
	SessionService sessionService;
	
	@Test
	@Order(1)
	public void addSessionTest() {
		Session session = new Session();
		Date startDate = new Date(2021, 07, 26);
		session.setSessionDateTime(startDate);
		sessionService.addSession(session);
		assertNotNull(sessionService.getSessionById(1));
	}
	
	@Test
	@Order(2)
	public void getAllSessionsTest() {
		List<Session> sessionList = sessionService.getAllSessions();
		assertThat(sessionList).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void getSessionByIdTest() {
		Date date = new Date(2021, 07, 26);
		Session session = sessionService.getSessionById(1);
		assertEquals(date, session.getSessionDateTime());
	}
	
	@Test
	@Order(4)
	public void updateSessionTest() {
		Date date = new Date(2021, 06, 26);
		Session session = sessionService.getSessionById(1);
		session.setSessionDateTime(date);
		sessionService.updateSession(session);
		assertNotEquals("xyz", sessionService.getSessionById(1).getSessionDateTime());
	}
	
	@Test
	@Order(5)
	public void deleteSessionTest() {
		sessionService.deleteSession(1);
		assertFalse(sessionRepository.existsById(1));
	}
}
