package net.javaguides.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface SurveyService extends UserDetailsService {
	String getAll(); 
}