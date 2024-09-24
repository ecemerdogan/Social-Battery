package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "events")
public class Events {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
	@Column(name = "event_name")
    private String eventName;
	
	@Column(name = "event_link")
    private String eventLink;
	
	@Column(name = "event_img")
    private String eventImage;
	
	@Column(name = "weather")
    private String weather;
	
	public Events() {
        // Default constructor
    }
	public Events(Long id, String eventName, String eventLink, String eventImage, String weather) {
		this.id = id;
		this.eventName = eventName;
		this.eventLink = eventLink;
		this.eventImage = eventImage;
		this.weather = weather;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventLink() {
		return eventLink;
	}

	public void setEventLink(String eventLink) {
		this.eventLink = eventLink;
	}

	public String getEventImage() {
		return eventImage;
	}

	public void setEventImage(String eventImage) {
		this.eventImage = eventImage;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}
	
	
}
