package com.eduflex.eduflexbackend.repository;

import com.eduflex.eduflexbackend.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {
}
