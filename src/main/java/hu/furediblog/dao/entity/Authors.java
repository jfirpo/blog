package hu.furediblog.dao.entity;


import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Table
@Entity
public class Authors implements BlogEntity{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
	private String name;
	
	public Authors() {		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}			
}
