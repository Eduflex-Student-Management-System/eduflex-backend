package com.eduflex.eduflexbackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduflex.eduflexbackend.model.Hod;
import com.eduflex.eduflexbackend.repository.HodRepository;
import com.eduflex.eduflexbackend.service.HodService;

@Service
public class HodServiceImpl implements HodService{

	@Autowired
	HodRepository hodRepository;
	
	@Override
	public Hod addHod(Hod hod) {
		return hodRepository.save(hod);
	}

	@Override
	public Hod updateHod(Hod hod) {
		return hodRepository.save(hod);
	}

	@Override
	public void deleteHodByHodId(int hodId) {
		hodRepository.deleteById(hodId);
	}

	@Override
	public List<Hod> getAllHodies() {
		return hodRepository.findAll();
	}

	@Override
	public Hod getHodByHodId(int hodId) {
		return hodRepository.findById(hodId).get();
	}
}
