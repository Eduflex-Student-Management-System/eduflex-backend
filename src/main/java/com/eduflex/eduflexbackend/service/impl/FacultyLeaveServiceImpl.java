package com.eduflex.eduflexbackend.service.impl;

import com.eduflex.eduflexbackend.model.Faculty;
import com.eduflex.eduflexbackend.model.FacultyLeave;
import com.eduflex.eduflexbackend.repository.FacultyLeaveRepository;
import com.eduflex.eduflexbackend.repository.FacultyRepository;
import com.eduflex.eduflexbackend.service.FacultyLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyLeaveServiceImpl implements FacultyLeaveService {

    @Autowired
    FacultyLeaveRepository facultyLeaveRepository;

    @Autowired
    FacultyRepository facultyRepository;

    @Override
    public List<FacultyLeave> getAllFacultyLeaves() {
        return facultyLeaveRepository.findAll();
    }

    @Override
    public void deleteFacultyLeave(int facultyId, int facultyLeaveId) {
        Faculty faculty = facultyRepository.findById(facultyId).get();
        List<FacultyLeave> facultyLeaveList = facultyLeaveRepository.findFacultyLeavesByFaculty(faculty);
        for (FacultyLeave facultyLeave : facultyLeaveList) {
            if (facultyLeave.getFacultyLeaveId() == facultyLeaveId) {
                facultyLeaveRepository.deleteById(facultyLeaveId);
            }
        }
    }

    @Override
    public List<FacultyLeave> getFacultyLeavesByFacultyId(int facultyId) {
        Faculty faculty = facultyRepository.findById(facultyId).get();
        return facultyLeaveRepository.findFacultyLeavesByFaculty(faculty);
    }

    @Override
    public FacultyLeave getFacultyLeaveByFacultyLeaveId(int facultyId, int facultyLeaveId) {
        return facultyLeaveRepository.findById(facultyLeaveId).get();
    }

    @Override
    public FacultyLeave addFacultyLeaveToFaculty(int facultyId, FacultyLeave facultyLeave) {
        Faculty faculty = facultyRepository.findById(facultyId).get();
        facultyLeave.setFaculty(faculty);
        return facultyLeaveRepository.save(facultyLeave);
    }

    @Override
    public void deleteFacultyLeaveByFacultyLeaveID(int facultyLeaveId) {
        facultyLeaveRepository.deleteById(facultyLeaveId);


    }


}
