package hu.furediblog.dao.model;


import javax.persistence.*;




@Table
@Entity
public class Authors implements BlogEntity{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

	public Authors() {		
	}


	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}	
	private String name;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}			
}
