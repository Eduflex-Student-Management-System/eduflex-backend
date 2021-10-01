package com.eduflex.eduflexbackend;

import com.eduflex.eduflexbackend.model.Attendance;
import com.eduflex.eduflexbackend.model.AttendanceReport;
import com.eduflex.eduflexbackend.model.Student;
import com.eduflex.eduflexbackend.model.Subject;
import com.eduflex.eduflexbackend.repository.AttendanceReportRepository;
import com.eduflex.eduflexbackend.service.AttendanceReportService;
import com.eduflex.eduflexbackend.service.AttendanceService;
import com.eduflex.eduflexbackend.service.StudentService;
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
public class AttendanceReportCRUDTest {
	
	@Autowired
	AttendanceReportRepository attendanceReportRepository;
	
	@Autowired
	AttendanceReportService attendanceReportService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	AttendanceService attendanceService;
	
	@Autowired
	SubjectService subjectService;
	
	@Test
	@Order(1)
	public void addAttendanceAndStudentToAttendanceReportTest() {
		Student student = new Student();
		student.setStudentName("Akshay");
		student.setStudentUsername("akshaysargar");
		student.setStudentPassword("Akshay@123");
		student.setStudentCity("Panvel");
		student.setStudentAvatar("AkshayImageGoesHere");
		Student newStudent =  studentService.addStudent(student);
		
		Subject subject = new Subject();
		subject.setSubjectName("Java");
		Subject newSubject = subjectService.addSubject(subject);
		
		Attendance attendance = new Attendance();
		attendance.setAttendanceDate( new Date(2021, 07, 26));
		attendance.setSubject(newSubject);
		Attendance newAttendance = attendanceService.addSubjectToAttendance(1, attendance);
		
		AttendanceReport attendanceReport = new AttendanceReport();
		attendanceReport.setAttendanceStatus(true);
		attendanceReport.setAttendance(newAttendance);
		attendanceReport.setStudent(newStudent);
		
		attendanceReportService.addAttendanceAndStudentToAttendanceReport(attendanceReport, 1, 1);
		assertNotNull(attendanceReportService.getAttendanceReportByAttendanceReportId(1));
	}
	
	@Test
	@Order(2)
	public void getAllAttendanceReportsTest() {
		List<AttendanceReport> attendanceReportList = attendanceReportService.getAllAttendanceReports();
		assertThat(attendanceReportList).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void getAttendanceReportsByAttendanceIdTest() {
		AttendanceReport attendanceReport = attendanceReportService.getAttendanceReportByAttendanceReportId(1);
		assertEquals(true, attendanceReport.isAttendanceStatus());
	}
	
	@Test
	@Order(4)
	public void getAttendanceReportsByStudentIdTest() {
		List<AttendanceReport> attendanceReport = attendanceReportService.getAttendanceReportsByStudentId(1);
		assertThat(attendanceReport).size().isGreaterThan(0);
	}
	
	@Test
	@Order(5)
	public void getAttendanceReportsByAttendanceId() {
		List<AttendanceReport> attendanceReports = attendanceReportService.getAttendanceReportsByAttendanceId(1);
		assertThat(attendanceReports).size().isGreaterThan(0);
	}
	
	@Test
	@Order(6)
	public void updateAttendanceReportTest() {
		AttendanceReport attendanceReport =  attendanceReportService.getAttendanceReportByAttendanceReportId(1);
		attendanceReport.setAttendanceStatus(false);
		attendanceReportService.updateAttendanceReport(attendanceReport);
		assertNotEquals("true", attendanceReportService.getAttendanceReportByAttendanceReportId(1).isAttendanceStatus());
	}
	
//	@Test
//	@Order(7)
//	public void deleteAttendanceReportByAttendanceReportIdTest() {
//		attendanceReportService.deleteAttendanceReportByAttendanceReportId(1);;
//		assertFalse(attendanceReportRepository.existsById(1));
//	}

}
