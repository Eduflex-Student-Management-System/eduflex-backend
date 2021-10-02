package com.eduflex.eduflexbackend.service;

import com.eduflex.eduflexbackend.model.Result;

import java.util.List;

public interface ResultService {
    Result getResultByResultId(int resultId);

    Result addResultToStudent(Result result, int studentId);

    Result getResultByStudentId(int studentId);

    void deleteResultByResultId(int resultId);

    List<Result> getAllResults();
}
