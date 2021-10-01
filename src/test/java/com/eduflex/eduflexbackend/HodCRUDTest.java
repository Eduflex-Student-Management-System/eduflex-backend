package com.eduflex.eduflexbackend;

import com.eduflex.eduflexbackend.model.Hod;
import com.eduflex.eduflexbackend.repository.HodRepository;
import com.eduflex.eduflexbackend.service.HodService;
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
public class HodCRUDTest {
	
	@Autowired
	HodRepository hodRepository;
	
	@Autowired
	HodService hodService;
	
	@Test
	@Order(1)
	public void addHodTest() {
		Hod hod = new Hod();
		hod.setHodName("Akshay");
		hod.setHodUserName("akshaysargar");
		hod.setHodPassword("Akshay@123");
		hod.setHodCity("Navi Mumbai");
		hod.setHodAvatar("AvatargoesHere");
		hodService.addHod(hod);
		assertNotNull(hodService.getHodByHodId(1));
	}
	
	@Test
	@Order(2)
	public void getAllHodiesTest() {
		List<Hod> hodList = hodService.getAllHodies();
		assertThat(hodList).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void getgetHodByHodIdTest() {
		Hod hod = hodService.getHodByHodId(1);
		
		assertEquals("Akshay", hod.getHodName());
		assertEquals("akshaysargar", hod.getHodUserName());
		assertEquals("Akshay@123", hod.getHodPassword());
		assertEquals("Navi Mumbai", hod.getHodCity());
		assertEquals("AvatargoesHere", hod.getHodAvatar());
	}
	
	@Test
	@Order(4)
	public void updateHodTest() {
		Hod hod = hodService.getHodByHodId(1);
		hod.setHodCity("Panvel");
		hodService.updateHod(hod);
		assertNotEquals("Navi Mumbai", hodService.getHodByHodId(1).getHodCity());
	}
	
//	@Test
//	@Order(5)
//	public void deleteHodByHodITest() {
//		hodService.deleteHodByHodId(1);
//		assertFalse(hodRepository.existsById(1));
//	}	
		
}
