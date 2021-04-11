package hu.furediblog.dao.model;

import java.util.List;

import javax.persistence.*;

//rename to BlogAuthor - pipa
@Table
@Entity
public class BlogAuthor{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
	
	private String name;
	
	@OneToMany(mappedBy = "author")
	private List<BlogEntry> entries;	

	public BlogAuthor() {		
	}


	public List<BlogEntry> getEntries() {
		return entries;
	}


	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}
