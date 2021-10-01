package com.eduflex.eduflexbackend;

import com.eduflex.eduflexbackend.model.Course;
import com.eduflex.eduflexbackend.model.Student;
import com.eduflex.eduflexbackend.repository.CourseRepository;
import com.eduflex.eduflexbackend.repository.StudentRepository;
import com.eduflex.eduflexbackend.service.CourseService;
import com.eduflex.eduflexbackend.service.StudentService;
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
public class CourseCRUDTest {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	StudentService studentService;
	
	@Test
	@Order(1)
	public void addCourseTest() {
		Course course = new Course();
		course.setCourseName("BTech");
		courseService.addCourse(course);
		assertNotNull(courseService.getCourseByCourseId(1));
	}
	
	@Test
	@Order(2)
	public void  getAllCoursesTest() {
		List<Course> courseList  = courseService.getAllCourses();
		assertThat(courseList).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void getCourseByCourseIdTest() {
		Course course = courseService.getCourseByCourseId(1);
		assertEquals("BTech", course.getCourseName());
	}
	
	@Test
	@Order(4)
	public void updateCourseTest() {
		Course course = courseService.getCourseByCourseId(1);
		course.setCourseName("BE");
		courseService.addCourse(course);
		assertNotEquals("BCA", courseService.getCourseByCourseId(1).getCourseName());
	}
	
//	@Test
//	@Order(5)
//	public void deleteCourseTest() {
//		courseRepository.deleteById(1);
//		assertFalse(courseRepository.existsById(1));
//	}
	
	@Test
	@Order(5)
	public void addCourseToStudentTest() {
		Course course = new Course();
		course.setCourseName("BBA");
		Course newCourse = courseService.addCourse(course);
		
		Student student = new Student();
		student.setStudentName("Akshay");
		student.setStudentUsername("akshaysargar");
		student.setStudentPassword("Akshay@123");
		student.setStudentCity("Panvel");
		student.setStudentAvatar("AkshayImageGoesHere");
		student.setCourse(newCourse);
		studentService.addStudent(student);
		
		courseService.addCourseToStudent(1, 1);
		assertNotNull(courseService.getCourseByCourseId(1));
	}

}
