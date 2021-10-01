package com.eduflex.eduflexbackend;

import com.eduflex.eduflexbackend.model.Attendance;
import com.eduflex.eduflexbackend.model.Subject;
import com.eduflex.eduflexbackend.repository.AttendanceRepository;
import com.eduflex.eduflexbackend.service.AttendanceService;
import com.eduflex.eduflexbackend.service.SubjectService;
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
public class AttendanceCRUDTest {
	
	@Autowired
	AttendanceRepository attendanceRepository;
	
	@Autowired
	AttendanceService attendanceService;
	
	@Autowired
	SubjectService subjectService;
	
	@Test
	@Order(1)
	public void addSubjectToAttendancTest() {
		Subject subject = new Subject();
		subject.setSubjectName("Java");
		Subject newSubject=subjectService.addSubject(subject);
		
		Attendance attendance = new Attendance();
		Date attendanceDate = new Date(2021, 05, 21);
		attendance.setAttendanceDate(attendanceDate);
		attendance.setSubject(newSubject);
		
		attendanceService.addSubjectToAttendance(1, attendance);
		assertNotNull(attendanceService.getAttendanceById(1));
	}
	
	@Test
	@Order(2)
	public void getAllAttendancesTest() {
		List<Attendance> attendanceList = attendanceService.getAllAttendances();
		assertThat(attendanceList).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void getAttendanceByIdTest() {
		Date attendanceDate = new Date(2021, 05, 21);
		Attendance attendance = attendanceService.getAttendanceById(1);
		assertEquals(attendanceDate, attendance.getAttendanceDate());
	}
	
	@Test
	@Order(4)
	public void updateAttendanceTest() {
		Subject subject = new Subject();
		subject.setSubjectName("Java");
		subjectService.addSubject(subject);
		
		Attendance attendance = attendanceService.getAttendanceById(1);
		attendance.setAttendanceDate( new Date(2021, 07, 26));
		attendance.setSubject(subjectService.getSubjectBySubjectId(1));
		
		attendanceService.addSubjectToAttendance(1, attendance);
		assertNotEquals("2021-08-31", attendanceService.getAttendanceById(1).getAttendanceDate());
	}
	
//	@Test
//	@Order(5)
//	public void deleteAttendanceTest() {
//		attendanceService.deleteAttendanceByAttendanceId(1);;
//		assertFalse(attendanceRepository.existsById(1));
//	}

}
