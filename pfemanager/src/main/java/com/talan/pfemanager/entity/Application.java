package com.talan.pfemanager.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "application")
public class Application implements Serializable {
    private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "cover_letter")
	private String coverLetter;
	private String resume;
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	@ManyToOne
	@JoinColumn(name = "subject_id", nullable = false)
	private Subject subject;
	
	public Application(String coverLetter, String resume, User user, Subject subject) {
		this.coverLetter = coverLetter;
		this.resume = resume;
		this.user = user;
		this.subject = subject;
	}
	
	public String getCoverLetter() {
		return coverLetter;
	}

	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}

	public Application() {
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
}
