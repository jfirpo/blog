package hu.furediblog.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import hu.furediblog.dao.model.Authors;

@Repository
public class AuthorRepository implements AuthorDao {
	
    
	protected Session getSession() {
        return DatabaseSessionProvider.getInstance().getSessionObj();
    }	
	
    public Class<Authors> getManagedClass() {
        return Authors.class;
    }
    
	public void addAuthor(Authors author) {
	       getSession().beginTransaction();
	       getSession().save(author);
	       getSession().getTransaction().commit();		
	}

	public void updateAuthor(Authors author) {
        getSession().beginTransaction();
        getSession().update(author);
        getSession().getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	public List<Authors> listAuthors() {		
		return getSession().createQuery("from " + getManagedClass().getSimpleName()).list();
	}

	public Authors getAuthorById(int id) {		
		return (Authors) getSession().get(Authors.class, id);
	}

	public void removeAuthor(int id) {
        getSession().beginTransaction();
        getSession().delete(getAuthorById(id));
        getSession().getTransaction().commit();				
	}		
}
