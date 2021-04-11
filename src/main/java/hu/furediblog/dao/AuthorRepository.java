package hu.furediblog.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import hu.furediblog.dao.model.BlogAuthor;
import hu.furediblog.dao.model.BlogEntry;

@Repository
public class AuthorRepository implements AuthorDao {
	
    
	protected Session getSession() {
        return DatabaseSessionProvider.getInstance().getSessionObj();
    }	
	
    public Class<BlogAuthor> getManagedClass() {
        return BlogAuthor.class;
    }
    
	public void addAuthor(BlogAuthor author) {
	       getSession().beginTransaction();
	       getSession().save(author);
	       getSession().getTransaction().commit();		
	}

	public void updateAuthor(BlogAuthor author) {
        getSession().beginTransaction();
        getSession().update(author);
        getSession().getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	public List<BlogAuthor> listAuthors() {		
		return getSession().createQuery("from " + getManagedClass().getSimpleName()).list();
	}
	
	public List<BlogAuthor> listActiveAuthors() {
		List<BlogAuthor> authors = new ArrayList<BlogAuthor>();
		for(BlogAuthor author : listAuthors()) {
			if (!author.getName().contains("deleted author"))
				authors.add(author);
		}
		return authors;
	}
	
	public BlogAuthor getAuthorById(int id) {		
		return (BlogAuthor) getSession().get(BlogAuthor.class, id);
	}

	public void removeAuthor(int id) {
        getSession().beginTransaction();
        getSession().delete(getAuthorById(id));
        getSession().getTransaction().commit();				
	}

	public List<BlogEntry> listauthorsEntries(BlogAuthor author) {		
		return author.getEntries();
	}
}
