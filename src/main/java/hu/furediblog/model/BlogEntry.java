package hu.furediblog.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//rename to BlogEntry - pipa
@Table
@Entity
public class BlogEntry{
 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="author")
	private BlogAuthor author;

	private String content;
	private Date created;
	
	public BlogEntry() {		
	}

	public BlogEntry(BlogAuthor author, String content) {
		this.author = author;
		this.content = content;
	}
	
	public BlogAuthor getAuthor() {
		return author;
	}

	public void setAuthor(BlogAuthor author) {
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
