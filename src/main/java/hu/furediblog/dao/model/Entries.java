package hu.furediblog.dao.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//rename to BlogEntry
@Table
@Entity
public class Entries{
 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="author")
	private Authors author;

	private String content;
	private Date created;
	
	public Entries() {		
	}

	public Entries(Authors author, String content) {
		this.author = author;
		this.content = content;
	}
	
	public Authors getAuthor() {
		return author;
	}

	public void setAuthor(Authors author) {
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
