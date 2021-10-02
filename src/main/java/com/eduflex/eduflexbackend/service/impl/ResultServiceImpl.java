package com.eduflex.eduflexbackend.service.impl;

import com.eduflex.eduflexbackend.model.Result;
import com.eduflex.eduflexbackend.model.Student;
import com.eduflex.eduflexbackend.repository.ResultRepository;
import com.eduflex.eduflexbackend.repository.StudentRepository;
import com.eduflex.eduflexbackend.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    ResultRepository resultRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Result getResultByResultId(int resultId) {
        return resultRepository.findById(resultId).get();
    }

    @Override
    public Result addResultToStudent(Result result, int studentId) {
        Student student = studentRepository.findById(studentId).get();
        result.setStudent(student);
        return resultRepository.save(result);
    }

    @Override
    public Result getResultByStudentId(int studentId) {
        Student student = studentRepository.findById(studentId).get();
        return resultRepository.findResultByStudent(student);
    }

    @Override
    public void deleteResultByResultId(int resultId) {
        resultRepository.deleteById(resultId);
    }

    @Override
    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }
}
