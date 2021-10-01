package com.eduflex.eduflexbackend;

import com.eduflex.eduflexbackend.model.Student;
import com.eduflex.eduflexbackend.model.StudentFeedback;
import com.eduflex.eduflexbackend.repository.StudentFeedbackRepository;
import com.eduflex.eduflexbackend.service.StudentFeedbackService;
import com.eduflex.eduflexbackend.service.StudentService;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class StudentFeedbackCRUDTest {
	
	@Autowired
	StudentFeedbackRepository studentFeedbackRepository;
	
	@Autowired
	StudentFeedbackService studentFeedbackService;
	
	@Autowired
	StudentService studentService;
	
	@Test
	@Order(1)
	public void addStudentFeedbackToStudentTest() {
		Student student = new Student();
		student.setStudentName("Akshay");
		student.setStudentUsername("akshaysargar");
		student.setStudentPassword("Akshay@123");
		student.setStudentCity("Panvel");
		student.setStudentAvatar("AkshayImageGoesHere");
		Student newStudent= studentService.addStudent(student);
		
		StudentFeedback studentFeedback = new StudentFeedback();
		
		studentFeedback.setStudentFeedback("All Good");
		studentFeedback.setStudent(newStudent);
		
		studentFeedbackService.addStudentFeedbackToStudent(1, studentFeedback);
		assertNotNull(studentFeedbackService.getStudentFeedbackByStudentFeedbackId(1));
	}
	
	@Test
	@Order(2)
	public void getAllStudentFeedbacksTest() {
		List<StudentFeedback> StudentFeedbackList = studentFeedbackService.getAllStudentFeedbacks();
		assertThat(StudentFeedbackList).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void getStudentFeedbackByStudentFeedbackIdTest() {
		StudentFeedback studentFeedback = studentFeedbackService.getStudentFeedbackByStudentFeedbackId(1);
		assertEquals("All Good",studentFeedback.getStudentFeedback());
	}
	
	@Test
	@Order(4)
	public void getStudentFeedbacksByStudentIdTest() {
		List<StudentFeedback> studentFeedbacks = studentFeedbackService.getStudentFeedbacksByStudentId(1);
		assertThat(studentFeedbacks).size().isGreaterThan(0);
	}
	
//	@Test
//	@Order(4)
//	public void deleteStudentFeedbackByStudentFeedbackIdTest() {
//		studentFeedbackService.deleteStudentFeedbackByStudentFeedbackId(1);
//		assertFalse(studentFeedbackRepository.existsById(1));
//	}
//	
//	@Test
//	@Order(5)
//	public void deleteStudentFeedbackByStudentIdTest() {
//		StudentFeedback studentFeedbackId = new StudentFeedback();
//		studentFeedbackId.setStudentFeedbackId(1);
//	
//		studentFeedbackService.deleteStudentFeedbackByStudentId(2, 1);
//		assertFalse(studentFeedbackRepository.existsById(1));
//		
//	}

}
