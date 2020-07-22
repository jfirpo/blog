package hu.furediblog.dao.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Entries{
 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	private int author;

	private String content;
	private Date created;
	
	public Entries() {		
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
