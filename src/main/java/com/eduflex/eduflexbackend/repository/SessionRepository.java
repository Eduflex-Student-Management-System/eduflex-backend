package com.eduflex.eduflexbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eduflex.eduflexbackend.model.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session,Integer> {
}
