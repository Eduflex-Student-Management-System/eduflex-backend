package com.eduflex.eduflexbackend;

import com.eduflex.eduflexbackend.model.Student;
import com.eduflex.eduflexbackend.model.StudentLeave;
import com.eduflex.eduflexbackend.repository.StudentLeaveRepository;
import com.eduflex.eduflexbackend.service.StudentLeaveService;
import com.eduflex.eduflexbackend.service.StudentService;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class StudentLeaveCRUDTest {
	
	@Autowired
	StudentLeaveRepository studentLeaveRepository;
	
	@Autowired
	StudentLeaveService studentLeaveService;
	
	@Autowired
	StudentService studentService;
	
	@Test
	@Order(1)
	public void addStudentLeaveToStudentTest() {
		Student student = new Student();
		student.setStudentName("Akshay");
		student.setStudentUsername("akshaysargar");
		student.setStudentPassword("Akshay@123");
		student.setStudentCity("Panvel");
		student.setStudentAvatar("AkshayImageGoesHere");
		Student newStudent = studentService.addStudent(student);
		
		StudentLeave studentLeave = new StudentLeave();
		Date date = new Date(2021, 06, 21);
		studentLeave.setStudentLeaveDate(date);
		studentLeave.setStudentLeaveStatus(true);
		studentLeave.setStudent(newStudent);
		
		studentLeaveService.addStudentLeaveToStudent(1, studentLeave);
		assertNotNull(studentLeaveService.getStudentLeaveByStudentLeaveId(1));
	}
	
	@Test
	@Order(2)
	public void getAllStudentLeavesTest() {
		List<StudentLeave> studentLeaveList = studentLeaveService.getAllStudentLeaves();
		assertThat(studentLeaveList).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void getStudentLeavesByStudentIdTest() {
		List<StudentLeave> studentLeaveList = studentLeaveService.getStudentLeavesByStudentId(1);
		assertThat(studentLeaveList).size().isGreaterThan(0);
	}
	
	@Test
	@Order(4)
	public void getStudentLeaveByStudentIdTest() {
		Date date = new Date(2021, 06, 21);
		StudentLeave studentLeave = studentLeaveService.getStudentLeaveByStudentLeaveId(1);
		assertEquals(date, studentLeave.getStudentLeaveDate());
	}
	
	
//	@Test
//	@Order(5)
//	public void deleteStudentLeaveByStudentLeaveIdTest() {
//		studentLeaveService.deleteStudentLeaveByStudentLeaveId(1);;
//		assertFalse(studentLeaveRepository.existsById(1));
//	}
//	
//	@Test
//	@Order(6)
//	public void deleteStudentLeaveByStudentId() {
//		studentLeaveService.deleteStudentLeaveByStudentId(1, 1);
//		assertFalse(studentLeaveRepository.existsById(1));
//	}

}
