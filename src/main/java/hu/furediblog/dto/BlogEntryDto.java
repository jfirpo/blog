package hu.furediblog.dto;

import java.util.Date;

public class BlogEntryDto {

	private int id;	
	private BlogAuthorDto author;
	private String content;
	private Date created;

	
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
	public BlogAuthorDto getAuthor() {
		return author;
	}
	public void setAuthor(BlogAuthorDto author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
