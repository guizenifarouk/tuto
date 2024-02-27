package com.talan.pfemanager.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

 

@Entity
@Table(name="Subject")
public class Subject implements  Serializable{
    private static final long serialVersionUID = 1L;
    @Id 
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    private int id;
    private String title;
    private String description;
    @Column(name = "publication_date")
    private Date publicationDate;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    
    @ManyToMany
    @JoinTable(
      name = "Technology_subject_associations", 
      joinColumns = @JoinColumn(name = "subject_id"), 
      inverseJoinColumns = @JoinColumn(name = "technology_id"))
    private Set<Technology> technologies;
    
    public Subject() {}
    public Subject(String title, String description, Date publicationDate,Date startDate,Date endDate,Set<Technology> technologies ) {
        this.title = title;
        this.description = description;
        this.publicationDate = publicationDate;
        this.startDate  = startDate;
        this.endDate = endDate;
        this.technologies = technologies;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getPublicationDate() {
        return publicationDate;
    }
    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public Set<Technology> getTechnologies() {
        return technologies;
    }
    public void setTechnologies(Set<Technology> technologies) {
        this.technologies = technologies;
    }
	@Override
	public String toString() {
		return "Subject [id=" + id + ", title=" + title + ", description=" + description + ", publicationDate="
				+ publicationDate + ", startDate=" + startDate + ", endDate=" + endDate + ", technologies="
				+ technologies + "]";
	}
    
}
