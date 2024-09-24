package net.javaguides.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Choices;

@Repository
public interface ChoicesRepository extends JpaRepository<Choices, Long> {
    Optional<Choices> findById(Long id);
  
    

}