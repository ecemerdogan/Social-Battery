package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "choices")
public class Choices {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "choice_id")
    private Long id;
	
	@Column(name = "question_id")
    private Long question_id;
	
    @Column(name = "choice")
    private String choice;
    
    @Column(name = "score")
    private int score;
    
    public Choices() {
        
    }
    
	public Choices(Long question_id, String choice, int score) {
		this.question_id = question_id;
		this.choice = choice;
		this.score = score;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long choice_id) {
		this.id = choice_id;
	}

	public Long getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(Long question_id) {
		this.question_id = question_id;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
    
    
}
