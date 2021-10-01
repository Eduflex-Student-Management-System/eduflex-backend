package com.eduflex.eduflexbackend;

import com.eduflex.eduflexbackend.model.ClassYear;
import com.eduflex.eduflexbackend.model.Student;
import com.eduflex.eduflexbackend.repository.ClassYearRepository;
import com.eduflex.eduflexbackend.repository.StudentRepository;
import com.eduflex.eduflexbackend.service.ClassYearService;
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
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class StudentCRUDTest {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ClassYearService classYearService;
	
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ClassYearRepository classYearRepository;

	@Test
	@Order(1)
	public void addStudentTest() {
		Student student = new Student();
		student.setStudentName("Akshay");
		student.setStudentUsername("akshaysargar");
		student.setStudentPassword("Akshay@123");
		student.setStudentCity("Panvel");
		student.setStudentAvatar("AkshayImageGoesHere");
		studentService.addStudent(student);
		
		assertNotNull(studentService.getStudentById(1));
	}
	
	@Test
	@Order(2)
	public void getAllStudentsTest() {
		List<Student> studentList = studentService.getAllStudents();
		assertThat(studentList).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void getStudentByIdTest() {
		Student student = studentService.getStudentById(1);
		
		assertEquals("Akshay", student.getStudentName());
		assertEquals("akshaysargar", student.getStudentUsername());
		assertEquals("Akshay@123", student.getStudentPassword());
		assertEquals("Panvel", student.getStudentCity());
		assertEquals("AkshayImageGoesHere", student.getStudentAvatar());
	}

	@Test
	@Order(4)
	public void updateStudentTest() {
		Student student = studentService.getStudentById(1);
		student.setStudentPassword("Suruchi@171");
	    studentService.updateStudent(student);
		assertNotEquals("Akshay@123", studentService.getStudentById(1).getStudentPassword());
	}
	
	@Test
	@Order(5)
	public void addClassYearToStudent() {
		ClassYear classYear = new ClassYear();
		Date startDate = new Date(2021, 07, 26);
		Date endDate   = new Date(2021, 11, 26);
		classYear.setClassYearStartDate(startDate);
		classYear.setClassYearEndDate(endDate);
		ClassYear newclasYear = classYearService.addClassYear(classYear);
		
		Student student = new Student();
		student.setStudentName("Akshay");
		student.setStudentUsername("akshaysargar");
		student.setStudentPassword("Akshay@123");
		student.setStudentCity("Panvel");
		student.setStudentAvatar("AkshayImageGoesHere");
		student.setClassYear(newclasYear);
		studentService.addClassYearToStudent(1, 1);
		assertNotNull(studentService.getStudentById(1));
	}
	
	@Test
	@Order(6)
	public void getAllStudentsByClassYearIdTest() {
		List<Student> studentList = studentService.getAllStudentsByClassYearId(1);
		assertThat(studentList).size().isGreaterThan(0);
	}

//	   @Test	
//	    @Order(5)
//	    public void deleteStudentTest() {
//		studentService.deleteStudent(1);
//		assertFalse(studentRepository.existsById(1));
	//}
	

	}
