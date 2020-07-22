package hu.furediblog.dao.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import hu.furediblog.dao.entity.Authors;

@Component
public class AuthorRepository extends AbstractRepository {
 		
	@SuppressWarnings("unchecked")
	public List<Authors> selectAll() {
        return getSession().createQuery("from Authors").list();
    }
	
	
	public Authors selectAuthor(int id){
		List<Authors> authors = selectAll();
		Authors author = new Authors();
		for (Authors author1 : authors) { 	
			if (author1.getId() == id)
				author = author1;
		}
		return author;
	}	
		
    public void save(Authors author) {
        getSession().beginTransaction();
        getSession().save(author);
        getSession().getTransaction().commit();
    }

    public void update(Authors author) {
        getSession().beginTransaction();
        getSession().update(author);
        getSession().getTransaction().commit();
    }
    
    public void remove(Authors author) {
        getSession().beginTransaction();
        getSession().delete(author);
        getSession().getTransaction().commit();
    }

}
