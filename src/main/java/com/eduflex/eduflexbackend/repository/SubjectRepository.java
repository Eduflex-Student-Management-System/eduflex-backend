package com.eduflex.eduflexbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduflex.eduflexbackend.model.Subject;
   
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
	

}
