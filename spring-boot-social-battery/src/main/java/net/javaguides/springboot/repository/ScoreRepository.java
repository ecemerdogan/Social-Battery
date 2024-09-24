package net.javaguides.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Scores;

@Repository
public interface ScoreRepository extends JpaRepository<Scores, Long> {
    Optional<Scores> findByUserId(Long userId);

   
}
