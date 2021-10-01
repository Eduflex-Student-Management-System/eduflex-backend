package com.eduflex.eduflexbackend;

import com.eduflex.eduflexbackend.model.Result;
import com.eduflex.eduflexbackend.model.Student;
import com.eduflex.eduflexbackend.repository.ResultRepository;
import com.eduflex.eduflexbackend.service.ResultService;
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
public class ResultCRUDTest {
	
	@Autowired
	ResultRepository resultRepository;
	
	@Autowired
	ResultService resultService;
	
	@Autowired
	StudentService studentService;
	
	@Test
	@Order(1)
	public void addResultTest() {
		Student student = new Student();
		student.setStudentName("Akshay");
		student.setStudentUsername("akshaysargar");
		student.setStudentPassword("Akshay@123");
		student.setStudentCity("Panvel");
		student.setStudentAvatar("AkshayImageGoesHere");
		Student newStudent = studentService.addStudent(student);
		
		
		
		Result result = new Result();
		result.setResultMarks(432.00);
		result.setStudent(newStudent);
		
		resultService.addResultToStudent(result, 1);
		assertNotNull(resultRepository.findById(1).get());
	}
	
	@Test
	@Order(2)
	public void  getAllResultsTest() {
		List<Result> resultList = resultService.getAllResults();
		assertThat(resultList).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void getResultByResultIdTest() {
		Result result = resultService.getResultByResultId(1);
		assertEquals(432.0, result.getResultMarks());
	}
	
	@Test
	@Order(4)
	public void getResultByStudentIdTest() {
		Result result = resultService.getResultByStudentId(1);
		assertEquals(432.0, result.getResultMarks());
	}
	
	
//	@Test
//	@Order(6)
//	public void deleteResultTest() {
//		resultService.deleteResultByResultId(1);
//		assertFalse(resultRepository.existsById(1));
//	}
//	
}
