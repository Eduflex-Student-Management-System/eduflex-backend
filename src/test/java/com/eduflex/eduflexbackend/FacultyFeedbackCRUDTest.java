package com.eduflex.eduflexbackend;

import com.eduflex.eduflexbackend.model.Faculty;
import com.eduflex.eduflexbackend.model.FacultyFeedback;
import com.eduflex.eduflexbackend.repository.FacultyFeedbackRepository;
import com.eduflex.eduflexbackend.service.FacultyFeedbackService;
import com.eduflex.eduflexbackend.service.FacultyService;
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
public class FacultyFeedbackCRUDTest {
	
	@Autowired
	FacultyFeedbackRepository facultyFeedbackRepository;
	
	@Autowired
	FacultyFeedbackService facultyFeedbackService;
	
	@Autowired
	FacultyService facultyService;

	@Test
	@Order(1)
	public void addFacultyFeedbackToFacultyTest() {
		Faculty faculty = new Faculty();
		faculty.setFacultyName("Vinay");
		faculty.setFacultyUsername("vinayiganhalli");
		faculty.setFacultyPassword("Vinay@123");
		faculty.setFacultyCity("Hubli");
		faculty.setFacultyAvatar("vinayIMGgoesHere");
		Faculty newFaculty = facultyService.addFaculty(faculty);
		
		FacultyFeedback facultyFeedback = new FacultyFeedback();
		facultyFeedback.setFacultyFeedback("Do some Increment");
		facultyFeedback.setFaculty(newFaculty);
		
		facultyFeedbackService.addFacultyFeedbackToFaculty(1, facultyFeedback);
		assertNotNull(facultyFeedbackService.getFacultyFeedbackByFacultyFeedbackId(1));
	}
	
	@Test
	@Order(2)
	public void getAllFacultiesTest() {
		List<FacultyFeedback> facultyFeedbackList = facultyFeedbackService.getAllFacultyFeedbacks();
		assertThat(facultyFeedbackList).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void getFacultyFeedbacksByFacultyId() {
		List<FacultyFeedback> facultyFeedbackList = facultyFeedbackService.getFacultyFeedbacksByFacultyId(1);
		assertThat(facultyFeedbackList).size().isGreaterThan(0);
	}
	
	@Test
	@Order(4)
	public void getFacultyByFacultyIdTest() {
		FacultyFeedback facultyFeedback = facultyFeedbackService.getFacultyFeedbackByFacultyFeedbackId(1);
		assertEquals("Do some Increment",facultyFeedback.getFacultyFeedback());
	}
	
	
	
//	@Test
//	@Order(4)
//	public void deleteFacultyFeedbackTest() {
//		facultyFeedbackService.deleteFacultyFeedbackByFacultyFeedbackId(1);
//		assertFalse(facultyFeedbackRepository.existsById(1));
//	}

}
