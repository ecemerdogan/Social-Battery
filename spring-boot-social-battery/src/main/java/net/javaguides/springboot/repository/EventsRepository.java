package net.javaguides.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Events;

public interface EventsRepository extends JpaRepository<Events, Long>{
	Optional<Events> findById(Long id);
}
