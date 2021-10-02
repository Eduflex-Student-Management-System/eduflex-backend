package com.eduflex.eduflexbackend.controller;

import com.eduflex.eduflexbackend.model.Hod;
import com.eduflex.eduflexbackend.repository.HodRepository;
import com.eduflex.eduflexbackend.service.HodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HodController {

    @Autowired
    HodService hodService;

    @Autowired
    HodRepository hodRepository;

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