package com.eduflex.eduflexbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.eduflex.eduflexbackend.model.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer>{
}
