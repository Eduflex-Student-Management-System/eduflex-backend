package com.eduflex.eduflexbackend;

import com.eduflex.eduflexbackend.model.Faculty;
import com.eduflex.eduflexbackend.model.FacultyLeave;
import com.eduflex.eduflexbackend.repository.FacultyLeaveRepository;
import com.eduflex.eduflexbackend.service.FacultyLeaveService;
import com.eduflex.eduflexbackend.service.FacultyService;
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
public class FacultyLeaveCRUDTest {
	
	@Autowired
	FacultyLeaveRepository facultyLeaveRepository;
	
	@Autowired
	FacultyLeaveService facultyLeaveService;
	
	@Autowired
	FacultyService facultyService;

	@Test
	@Order(1)
	public void addFacultyLeaveToFacultyTest() {
		Faculty faculty = new Faculty();

		faculty.setFacultyName("Vinay");
		faculty.setFacultyUsername("vinayiganhalli");
		faculty.setFacultyPassword("Vinay@123");
		faculty.setFacultyCity("Hubli");
		faculty.setFacultyAvatar("vinayIMGgoesHere");
		Faculty newFaculty =  facultyService.addFaculty(faculty);
		
		FacultyLeave facultyLeave = new FacultyLeave();
		Date startDate = new Date(2021, 05, 21);
		Date endDate = new Date(2021, 05, 26);
		facultyLeave.setFacultyLeaveStartDate(startDate);
		facultyLeave.setFacultyLeaveEndDate(endDate);
		facultyLeave.setFaculty(newFaculty);
		
		facultyLeaveService.addFacultyLeaveToFaculty(1, facultyLeave);
		assertNotNull(facultyLeaveService.getFacultyLeaveByFacultyLeaveId(1, 1));
	}
	
	@Test
	@Order(2)
	public void getAllFacultiesTest() {
		List<FacultyLeave> facultyLeaveList = facultyLeaveService.getAllFacultyLeaves();
		assertThat(facultyLeaveList).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void getFacultyLeaveByFacultyIdTest() {
		Date date = new Date(2021, 05, 21);
		List<FacultyLeave> facultyLeave = facultyLeaveService.getFacultyLeavesByFacultyId(1);
		assertThat(facultyLeave).size().isGreaterThan(0);
	}
	
	@Test
	@Order(4)
	public void getFacultyLeaveByFacultyLeaveIdTest() {
		Date date = new Date(2021, 05, 26);
		FacultyLeave facultyLeave = facultyLeaveService.getFacultyLeaveByFacultyLeaveId(1, 1);
		assertEquals(date, facultyLeave.getFacultyLeaveEndDate());	
	}
	
	
//	@Test
//	@Order(4)
//	public void deleteFacultyLeaveTest() {
//		facultyLeaveService.deleteFacultyLeave(3, 1);;
//		assertFalse(facultyLeaveRepository.existsById(1));
//	}

}
