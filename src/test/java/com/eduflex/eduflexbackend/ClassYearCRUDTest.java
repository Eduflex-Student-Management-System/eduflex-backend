package com.eduflex.eduflexbackend;

import com.eduflex.eduflexbackend.model.ClassYear;
import com.eduflex.eduflexbackend.repository.ClassYearRepository;
import com.eduflex.eduflexbackend.service.ClassYearService;
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
public class ClassYearCRUDTest {
	
	@Autowired
	ClassYearRepository classYearRepository;
	
	@Autowired
	ClassYearService classYearService;
	
	@Test
	@Order(1)
	public void addClassYear() {
		ClassYear classYear = new ClassYear();
		Date startDate = new Date(2021, 07, 26);
		Date endDate   = new Date(2021, 11, 26);
		classYear.setClassYearStartDate(startDate);
		classYear.setClassYearEndDate(endDate);
		classYearService.addClassYear(classYear);
		assertNotNull(classYearService.getClassYearById(1));
	}
	
	@Test
	@Order(2)
	public void getAllClassYearsTest() {
		List<ClassYear> classYeartList = classYearService.getAllClassYears();
		assertThat(classYeartList).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void getClassYearByIdTest() {
		Date startDate = new Date(2021, 07, 26);
		Date endDate   = new Date(2021, 11, 26);
		ClassYear classYear = classYearService.getClassYearById(1);
		assertEquals(startDate, classYear.getClassYearStartDate());
		assertEquals(endDate, classYear.getClassYearEndDate());
	}
	
	@Test
	@Order(4)
	public void updateClassYearTest() {
		ClassYear classYear = classYearService.getClassYearById(1);
		classYear.setClassYearEndDate( new Date(2021, 07, 26));
		classYearService.addClassYear(classYear);
		assertNotEquals("2021-08-31", classYearService.getClassYearById(1).getClassYearEndDate());
	}
	
//	@Test
//	@Order(5)
//	public void deleteClassYearTest() {
//		classYearService.deleteClassYearById(1);
//		assertFalse(classYearRepository.existsById(1));
//	}

}
