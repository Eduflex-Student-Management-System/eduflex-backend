package com.eduflex.eduflexbackend.repository;

import com.eduflex.eduflexbackend.model.ClassYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassYearRepository extends JpaRepository<ClassYear, Integer> {
}
