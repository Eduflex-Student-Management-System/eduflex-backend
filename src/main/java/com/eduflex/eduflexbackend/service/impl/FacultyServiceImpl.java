package com.eduflex.eduflexbackend.service.impl;

import com.eduflex.eduflexbackend.model.Faculty;
import com.eduflex.eduflexbackend.repository.FacultyRepository;
import com.eduflex.eduflexbackend.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    FacultyRepository facultyRepository;

    @Override
    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty updateFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    @Override
    public void deleteFaculty(int facultyId) {
        facultyRepository.deleteById(facultyId);
    }

    @Override
    public Faculty getFacultyByFacultyId(int facultyId) {
        return facultyRepository.findById(facultyId).get();
    }

    @Override
    public Faculty getFacultyByFacultyUsernameAndAndFacultyPassword(String facultyUsername, String facultyPassword) {
        return facultyRepository.findFacultyByFacultyUsernameAndAndFacultyPassword(facultyUsername, facultyPassword);
    }
}
