package hu.furediblog.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import hu.furediblog.dao.model.*;

@Repository
public class EntryRepository implements EntryDao{

	protected Session getSession() {
        return DatabaseSessionProvider.getInstance().getSessionObj();
    }
	
    public Class<BlogEntry> getManagedClass(){
        return BlogEntry.class;
    }	
			
	public void addEntry(BlogEntry entry) {
	       getSession().beginTransaction();
	       getSession().save(entry);
	       getSession().getTransaction().commit();		
	}

	public void updateEntry(BlogEntry entry) {
		 getSession().beginTransaction();
	     getSession().update(entry);
	     getSession().getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	public List<BlogEntry> listEntries() {		
		return getSession().createQuery("from " + getManagedClass().getSimpleName()).list();
	}

	public BlogEntry getEntryById(int id) {
		return (BlogEntry) getSession().get(BlogEntry.class, id);
	}

	public void removeEntry(int id) {
        getSession().beginTransaction();
        getSession().delete(getEntryById(id));
        getSession().getTransaction().commit();				
	}

	public void addEntry(BlogAuthor author, String content) {
		 getSession().beginTransaction();
	     getSession().save(new BlogEntry(author, content));
	     getSession().getTransaction().commit();
		
	}

	public List<BlogEntry> listAuthorEntries(int author) {
		List<BlogEntry> entryList = listEntries();
		List<BlogEntry> auhorEntryList = new ArrayList<BlogEntry>();
		for (BlogEntry entry : entryList){
			if (entry.getAuthor().getId() == author)
				auhorEntryList.add(entry);
		}
		return auhorEntryList;
	}
}
