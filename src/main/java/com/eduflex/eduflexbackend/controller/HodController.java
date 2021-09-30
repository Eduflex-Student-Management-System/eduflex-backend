package com.eduflex.eduflexbackend.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eduflex.eduflexbackend.exception.EduflexDataNotFoundException;
import com.eduflex.eduflexbackend.model.Hod;
import com.eduflex.eduflexbackend.repository.HodRepository;
import com.eduflex.eduflexbackend.service.HodService;

@RestController
@CrossOrigin
public class HodController {

    @Autowired
    HodService hodService;
    
    @Autowired
    HodRepository hodRepository;

    @PostMapping("/hod")
    public Hod addHod(@RequestBody Hod hod) {
    	if(StringUtils.isBlank(hod.getHodName())) {
    		throw new EduflexDataNotFoundException("Hod Name is required");
    	}
        return hodService.addHod(hod);
    }

    @PutMapping("/hod")
    public Hod updateHod(@RequestBody Hod hod) {
        return hodService.updateHod(hod);
    }

    @DeleteMapping("/hod/{hodId}")
    public void deleteHodByHod(@PathVariable int hodId) {
    	if(!hodRepository.existsById(hodId)) {
    		throw new EduflexDataNotFoundException("Can't delete Hod, hodId: "+hodId+" not persent in database");
    	}
        hodService.deleteHodByHodId(hodId);
    }

    @GetMapping("/hodies")
    public List<Hod> getAllHodies() {
    	if(hodRepository.findAll().size() == 0) {
			throw new EduflexDataNotFoundException("Hod Not Found, Add Hod first");
		}
        return hodService.getAllHodies();
    }

    @GetMapping("hod/{hodId}")
    public Hod getHodByHodId(@PathVariable int hodId) {
    	if(!hodRepository.existsById(hodId)) {
    		throw new EduflexDataNotFoundException("Can't find hod with hodId: "+hodId+", please insert first");
    	}
        return hodService.getHodByHodId(hodId);
    }


}