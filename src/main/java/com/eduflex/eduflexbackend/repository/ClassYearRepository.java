package com.eduflex.eduflexbackend.repository;

import com.eduflex.eduflexbackend.model.ClassYear;
import com.eduflex.eduflexbackend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassYearRepository extends JpaRepository<ClassYear, Integer> {
}
