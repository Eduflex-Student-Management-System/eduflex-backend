package com.eduflex.eduflexbackend.repository;

import com.eduflex.eduflexbackend.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
    Faculty findFacultyByFacultyUsernameAndAndFacultyPassword(String facultyUsername, String facultyPassword);
}
