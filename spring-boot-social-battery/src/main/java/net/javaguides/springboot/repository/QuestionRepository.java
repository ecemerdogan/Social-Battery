package net.javaguides.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Questions;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, Long> {
    Optional<Questions> findById(Long id);
}