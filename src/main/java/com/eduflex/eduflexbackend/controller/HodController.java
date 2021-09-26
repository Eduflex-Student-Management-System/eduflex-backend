package com.eduflex.eduflexbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eduflex.eduflexbackend.model.Hod;
import com.eduflex.eduflexbackend.service.HodService;

@RestController
@CrossOrigin
public class HodController {

	@Autowired
	HodService hodService;
	
	@PostMapping("/hod")
	public Hod addHod(@RequestBody Hod hod) {
		return hodService.addHod(hod);
	}

	@PutMapping("/hod")
	public Hod updateHod(@RequestBody Hod hod) {
		return hodService.updateHod(hod);
	}

	@DeleteMapping("/hod/{hodId}")
	public void deleteHodByHod(@PathVariable int hodId) {
		hodService.deleteHodByHodId(hodId);
	}

	@GetMapping("/hodies")
	public List<Hod> getAllHodies() {
		return hodService.getAllHodies();
	}
	
	@GetMapping("hod/{hodId}")
	public Hod getHodByHodId(@PathVariable int hodId) {
		return hodService.getHodByHodId(hodId);
	}

	
}
