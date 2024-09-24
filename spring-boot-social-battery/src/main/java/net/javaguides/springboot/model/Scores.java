package net.javaguides.springboot.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "scores")
@Component
public class Scores {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private int userScore;
	
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
	
	
    public Scores() {
        
    }


	public Scores(Long id, int userScore, User user) {
		this.id = id;
		this.userScore = userScore;
		this.user = user;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getUserScore() {
		return userScore;
	}


	public void setUserScore(int userScore) {
		this.userScore = userScore;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}



	
    
	
	
}
