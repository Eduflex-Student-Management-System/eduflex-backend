package com.eduflex.eduflexbackend;

import com.eduflex.eduflexbackend.model.Faculty;
import com.eduflex.eduflexbackend.model.Subject;
import com.eduflex.eduflexbackend.repository.SubjectRepository;
import com.eduflex.eduflexbackend.service.FacultyService;
import com.eduflex.eduflexbackend.service.SubjectService;
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
public class SubjectCRUDTest {
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	SubjectService subjectService;
	
	@Autowired
	FacultyService facultyService;
	
	@Test
	@Order(1)
	public void addSubjectTest() {
		Subject subject = new Subject();
		subject.setSubjectName("Java");
		subjectService.addSubject(subject);
		assertNotNull(subjectService.getSubjectBySubjectId(1));
	}
	
	@Test
	@Order(2)
	public void addSubjectToFaculty() {
        Faculty faculty = new Faculty();
        faculty.setFacultyName("Vinay");
        faculty.setFacultyUsername("vinayiganhalli");
        faculty.setFacultyPassword("Vinay@123");
        faculty.setFacultyCity("Hubli");
        faculty.setFacultyAvatar("vinayIMGgoesHere");
        Faculty newFaculty = facultyService.addFaculty(faculty);

        Subject subject = new Subject();
        subject.setSubjectName("Java");
        subject.setFaculty(newFaculty);
        subjectService.addSubjectToFaculty(1, 1);
        assertNotNull(subjectService.getSubjectBySubjectId(1));
    }
	
	@Test
	@Order(3)
	public void getAllSubjectsTest() {
		List<Subject> subjectList = subjectService.getAllSubjects();
		assertThat(subjectList).size().isGreaterThan(0);
	}
	
	@Test
	@Order(4)
	public void getAllSubjectsByFacultyIdTest() {
		List<Subject> subjectList = subjectService.getAllSubjectsByFacultyId(1);
		assertThat(subjectList).size().isGreaterThan(0);
	}
	
	@Test
	@Order(5)
	public void getSubjectBySubjectId() {
		Subject subject = subjectService.getSubjectBySubjectId(1);
		assertEquals("Java", subject.getSubjectName());
	}
	
	@Test
	@Order(6)
	public void updateSujectTest() {
		Subject subject = subjectService.getSubjectBySubjectId(1);
		subject.setSubjectName("Java&Spring");
		subjectService.updateSubject(subject);
		assertNotNull("Java",subjectService.getSubjectBySubjectId(1).getSubjectName());
	}
	
//	@Test
//	@Order(7)
//	public void deleteSubjectTest() {
//		Subject subject = new Subject();
//		subject.setSubjectId(2);
//		subjectService.deleteSubjectBySubjectId(2);
//		assertFalse(subjectRepository.existsById(2));
//	}
	
	
}
