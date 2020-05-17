package com.apress.spring.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Journal { //DB에 저장 가능한 JPA Entity
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private Date created;
	private String summary;
	
	@Transient // JPA 엔진이 값을 무시(DB에 저장이 안됨)
	private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getCreatedAsShort() {
		return format.format(created);
	}

	@Override
	public String toString() {
		return "Journal [id=" + id + ", title=" + title + ", created=" + created + ", summary=" + summary + "]";
	}

	public Journal(String title, String summary, String date)throws ParseException{
		this.title = title;
		this.summary = summary;
		this.created = format.parse(date);
	}

	public Journal() {}
	
}
