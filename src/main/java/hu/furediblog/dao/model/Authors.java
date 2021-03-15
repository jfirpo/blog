package hu.furediblog.dao.model;

import java.util.List;

import javax.persistence.*;

//rename to BlogAuthorDto
@Table
@Entity
public class Authors{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
	
	private String name;
	
	@OneToMany(mappedBy = "author")
	private List<Entries> entries;	

	public Authors() {		
	}


	public List<Entries> getEntries() {
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
