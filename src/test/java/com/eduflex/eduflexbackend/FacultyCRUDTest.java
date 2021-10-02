package com.eduflex.eduflexbackend;

import com.eduflex.eduflexbackend.model.Faculty;
import com.eduflex.eduflexbackend.repository.FacultyRepository;
import com.eduflex.eduflexbackend.service.FacultyService;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class FacultyCRUDTest {
	
	@Autowired
	FacultyService facultyService;
	
	@Autowired
	FacultyRepository facultyRepository;
	
	@Test
	@Order(1)
	public void addFacultyTest() {
        Faculty faculty = new Faculty();
        faculty.setFacultyName("Vinay");
        faculty.setFacultyUsername("vinayiganhalli");
        faculty.setFacultyPassword("Vinay@123");
        faculty.setFacultyCity("Hubli");
        faculty.setFacultyAvatar("vinayIMGgoesHere");
        facultyService.addFaculty(faculty);
        assertNotNull(facultyService.getFacultyByFacultyId(1));
    }
	
	@Test
	@Order(2)
	public void getAllFacultiesTest() {
		List<Faculty> facultyList = facultyService.getAllFaculties();
		assertThat(facultyList).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void getFacultyByFacultyIdTest() {
		Faculty faculty = facultyService.getFacultyByFacultyId(1);
		assertEquals("Vinay", faculty.getFacultyName());
		assertEquals("vinayiganhalli", faculty.getFacultyUsername());
		assertEquals("vinayIMGgoesHere", faculty.getFacultyAvatar());
		assertEquals("Vinay@123", faculty.getFacultyPassword());
		assertEquals("Hubli", faculty.getFacultyCity());
	}
	
	@Test
	@Order(4)
	public void updateFacultyTest() {
		Faculty faculty = facultyService.getFacultyByFacultyId(1);
		faculty.setFacultyPassword("Vinay@171");
		facultyService.updateFaculty(faculty);
		assertNotEquals("Vinay@123", facultyService.getFacultyByFacultyId(1).getFacultyPassword());
	}
	
//	@Test
//	@Order(5)
//	public void deleteFacultyTest() {
//		facultyService.deleteFaculty(1);
//		assertFalse(facultyRepository.existsById(1));
//	}
	
}
