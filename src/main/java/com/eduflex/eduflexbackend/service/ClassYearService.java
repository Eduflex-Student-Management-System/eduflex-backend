package com.eduflex.eduflexbackend.service;

import com.eduflex.eduflexbackend.model.ClassYear;
import com.eduflex.eduflexbackend.model.Student;

import java.util.List;

public interface ClassYearService {
    ClassYear addClassYear(ClassYear classYear);
    ClassYear getClassYearById(int classYearId);
    void deleteClassYearById(int classYearId);
    List<ClassYear> getAllClassYears();
    ClassYear addClassYearToStudent(int studentId, int classYearId);

}
